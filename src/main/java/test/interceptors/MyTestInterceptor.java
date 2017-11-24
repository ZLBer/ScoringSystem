package test.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import test.GlobleVariance;
import test.domain.InformationAll;
import test.domain.InformationAllExample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 匹配方式
 * 0 精准
 * 1 模糊
 * 2 大于
 * 3 小于
 * 4 之间
 */
public class MyTestInterceptor implements HandlerInterceptor {
    private final String TAG = "MyTestInterceptor";

    private String[] args = GlobleVariance.args;
    private String[] methodSuffix = {
            "EqualTo",
            "Like",
            "GreaterThan",
            "LessThan",
            "Between"
    };

    private boolean needOr = false;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(TAG+" : >>>>>>>>>>>>>>>>>>>>>>>>>preHandle<<<<<<<<<<<<<<<<<<<<<<");
        String[][] params = getParameters(httpServletRequest);
        InformationAllExample example = generateExample(params);
        httpServletRequest.setAttribute("example",example);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(TAG+" : >>>>>>>>>>>>>>>>>>>>>>>>>postHandle<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(TAG+" : >>>>>>>>>>>>>>>>>>>>>>>>>afterComplete<<<<<<<<<<<<<<<<<<<<<<");
    }

    private String[][] getParameters(HttpServletRequest request){
        String[][] params = new String[args.length][4];
        String[] selectArgs = new String[args.length];
        for (int i=0;i<args.length;i++){
            params[i][0] = request.getParameter(args[i]);
            params[i][2] = request.getParameter(args[i]+"2");
            selectArgs[i] = args[i]+"Type";
        }
        for (int i=0;i<args.length;i++){
            params[i][1] = request.getParameter(selectArgs[i]);
            params[i][3] = request.getParameter(selectArgs[i]+"2");
        }
        return params;
    }

    private InformationAllExample generateExample(String[][] params){
        String order = "a.id asc";
        InformationAllExample example = new InformationAllExample();
        InformationAllExample.Criteria criteria = example.createCriteria();
        InformationAllExample.Criteria criteriaOr = example.createCriteria();
        for (int i=0;i<args.length;i++){
            if (params[i][0]==null||params[i][0].equals("")) continue;
            addAndCondition(criteria,criteriaOr,params[i],args[i]);
        }
        if (needOr){
            example.or(criteriaOr);
        }
        example.setOrderByClause(order);
        return example;
    }

    /**
     *
     * @param criteria 第一个条件
     * @param criteria2 用于或运算的条件
     * @param a 参数名对应的参数数组行
     * @param p 参数名
     */
    private void addAndCondition(InformationAllExample.Criteria criteria, InformationAllExample.Criteria criteria2, String[] a, String p) {
        boolean hasOr = false;
        if (a[2]!=null&&!a[2].equals("")){
            hasOr = true;
            needOr = true;
        }

        String m = methodSuffix[Integer.parseInt(a[1])];
        String methodName = "and"+p.substring(0,1).toUpperCase()+p.substring(1,p.length())+m;

        Logger.getLogger(MyTestInterceptor.class).info(methodName);
        try {
            Field field = InformationAll.class.getDeclaredField(p);
            Class c = field.getType();
            InvokeCriteriaMethod(criteria,c,methodName,a,0);
            if (hasOr){
                InvokeCriteriaMethod(criteria2,c,methodName,a,2);
            }else{
                InvokeCriteriaMethod(criteria2,c,methodName,a,0);
            }
//            Method method;
//            Class clazz = criteria.getClass();
//            if (c==Integer.class) {
//                if (a[startIndex+1].equals("4")) {
//                    String[] strArgu = a[startIndex].split(" ");
//                    Integer[] intArgu = {Integer.valueOf(strArgu[startIndex]), Integer.valueOf(strArgu[1])};
//                    method = clazz.getDeclaredMethod(methodName, new Class[]{c, c});
//                    method.invoke(criteria, intArgu[startIndex],intArgu[startIndex+1]);
//                }else{
//                    method = clazz.getDeclaredMethod(methodName,new Class[]{c});
//                    method.invoke(criteria,Integer.parseInt(a[startIndex]));
//                }
//            }else if (c==String.class){
//                method = clazz.getDeclaredMethod(methodName,new Class[]{c});
//                if (a[startIndex+1].equals("1")){
//                    method.invoke(criteria,"%"+a[startIndex]+"%");
//                }else {
//                    method.invoke(criteria, a[startIndex]);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void InvokeCriteriaMethod(InformationAllExample.Criteria criteria,Class fieldType,String methodName,String[] paramRow,int startIndex){
        try {
            Class clazz = criteria.getClass();
            Method method;
            if (fieldType == Integer.class) {
                if (paramRow[startIndex + 1].equals("4")) {
                    String[] strArgu = paramRow[startIndex].split(" ");
                    Integer[] intArgu = {Integer.valueOf(strArgu[0]), Integer.valueOf(strArgu[1])};
                    method = clazz.getDeclaredMethod(methodName, new Class[]{fieldType, fieldType});
                    method.invoke(criteria, intArgu[startIndex], intArgu[startIndex + 1]);
                } else {
                    method = clazz.getDeclaredMethod(methodName, new Class[]{fieldType});
                    method.invoke(criteria, Integer.parseInt(paramRow[startIndex]));
                }
            } else if (fieldType == String.class) {
                method = clazz.getDeclaredMethod(methodName, new Class[]{fieldType});
                if (paramRow[startIndex + 1].equals("1")) {
                    method.invoke(criteria, "%" + paramRow[startIndex] + "%");
                } else {
                    method.invoke(criteria, paramRow[startIndex]);
                }
            } else if (fieldType == Date.class){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Logger.getLogger(MyTestInterceptor.class).info(paramRow[startIndex]);
                if (paramRow[startIndex + 1].equals("4")) {
                    String[] strArgu = paramRow[startIndex].split(" ");
                    Date[] intArgu = {dateFormat.parse(strArgu[0]), dateFormat.parse(strArgu[1])};
                    method = clazz.getDeclaredMethod(methodName, new Class[]{fieldType, fieldType});
                    method.invoke(criteria, intArgu[startIndex], intArgu[startIndex + 1]);
                } else {
                    method = clazz.getDeclaredMethod(methodName, new Class[]{fieldType});
                    method.invoke(criteria, dateFormat.parse(paramRow[startIndex]));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
