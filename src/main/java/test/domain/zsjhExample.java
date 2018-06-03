package test.domain;

import java.util.ArrayList;
import java.util.List;

public class zsjhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public zsjhExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNfIsNull() {
            addCriterion("nf is null");
            return (Criteria) this;
        }

        public Criteria andNfIsNotNull() {
            addCriterion("nf is not null");
            return (Criteria) this;
        }

        public Criteria andNfEqualTo(String value) {
            addCriterion("nf =", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfNotEqualTo(String value) {
            addCriterion("nf <>", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfGreaterThan(String value) {
            addCriterion("nf >", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfGreaterThanOrEqualTo(String value) {
            addCriterion("nf >=", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfLessThan(String value) {
            addCriterion("nf <", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfLessThanOrEqualTo(String value) {
            addCriterion("nf <=", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfLike(String value) {
            addCriterion("nf like", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfNotLike(String value) {
            addCriterion("nf not like", value, "nf");
            return (Criteria) this;
        }

        public Criteria andNfIn(List<String> values) {
            addCriterion("nf in", values, "nf");
            return (Criteria) this;
        }

        public Criteria andNfNotIn(List<String> values) {
            addCriterion("nf not in", values, "nf");
            return (Criteria) this;
        }

        public Criteria andNfBetween(String value1, String value2) {
            addCriterion("nf between", value1, value2, "nf");
            return (Criteria) this;
        }

        public Criteria andNfNotBetween(String value1, String value2) {
            addCriterion("nf not between", value1, value2, "nf");
            return (Criteria) this;
        }

        public Criteria andSfdmIsNull() {
            addCriterion("sfdm is null");
            return (Criteria) this;
        }

        public Criteria andSfdmIsNotNull() {
            addCriterion("sfdm is not null");
            return (Criteria) this;
        }

        public Criteria andSfdmEqualTo(String value) {
            addCriterion("sfdm =", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotEqualTo(String value) {
            addCriterion("sfdm <>", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmGreaterThan(String value) {
            addCriterion("sfdm >", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmGreaterThanOrEqualTo(String value) {
            addCriterion("sfdm >=", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmLessThan(String value) {
            addCriterion("sfdm <", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmLessThanOrEqualTo(String value) {
            addCriterion("sfdm <=", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmLike(String value) {
            addCriterion("sfdm like", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotLike(String value) {
            addCriterion("sfdm not like", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmIn(List<String> values) {
            addCriterion("sfdm in", values, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotIn(List<String> values) {
            addCriterion("sfdm not in", values, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmBetween(String value1, String value2) {
            addCriterion("sfdm between", value1, value2, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotBetween(String value1, String value2) {
            addCriterion("sfdm not between", value1, value2, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfIsNull() {
            addCriterion("sf is null");
            return (Criteria) this;
        }

        public Criteria andSfIsNotNull() {
            addCriterion("sf is not null");
            return (Criteria) this;
        }

        public Criteria andSfEqualTo(String value) {
            addCriterion("sf =", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotEqualTo(String value) {
            addCriterion("sf <>", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfGreaterThan(String value) {
            addCriterion("sf >", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfGreaterThanOrEqualTo(String value) {
            addCriterion("sf >=", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfLessThan(String value) {
            addCriterion("sf <", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfLessThanOrEqualTo(String value) {
            addCriterion("sf <=", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfLike(String value) {
            addCriterion("sf like", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotLike(String value) {
            addCriterion("sf not like", value, "sf");
            return (Criteria) this;
        }

        public Criteria andSfIn(List<String> values) {
            addCriterion("sf in", values, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotIn(List<String> values) {
            addCriterion("sf not in", values, "sf");
            return (Criteria) this;
        }

        public Criteria andSfBetween(String value1, String value2) {
            addCriterion("sf between", value1, value2, "sf");
            return (Criteria) this;
        }

        public Criteria andSfNotBetween(String value1, String value2) {
            addCriterion("sf not between", value1, value2, "sf");
            return (Criteria) this;
        }

        public Criteria andCcIsNull() {
            addCriterion("cc is null");
            return (Criteria) this;
        }

        public Criteria andCcIsNotNull() {
            addCriterion("cc is not null");
            return (Criteria) this;
        }

        public Criteria andCcEqualTo(String value) {
            addCriterion("cc =", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotEqualTo(String value) {
            addCriterion("cc <>", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcGreaterThan(String value) {
            addCriterion("cc >", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcGreaterThanOrEqualTo(String value) {
            addCriterion("cc >=", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLessThan(String value) {
            addCriterion("cc <", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLessThanOrEqualTo(String value) {
            addCriterion("cc <=", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLike(String value) {
            addCriterion("cc like", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotLike(String value) {
            addCriterion("cc not like", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcIn(List<String> values) {
            addCriterion("cc in", values, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotIn(List<String> values) {
            addCriterion("cc not in", values, "cc");
            return (Criteria) this;
        }

        public Criteria andCcBetween(String value1, String value2) {
            addCriterion("cc between", value1, value2, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotBetween(String value1, String value2) {
            addCriterion("cc not between", value1, value2, "cc");
            return (Criteria) this;
        }

        public Criteria andZydmIsNull() {
            addCriterion("zydm is null");
            return (Criteria) this;
        }

        public Criteria andZydmIsNotNull() {
            addCriterion("zydm is not null");
            return (Criteria) this;
        }

        public Criteria andZydmEqualTo(String value) {
            addCriterion("zydm =", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmNotEqualTo(String value) {
            addCriterion("zydm <>", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmGreaterThan(String value) {
            addCriterion("zydm >", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmGreaterThanOrEqualTo(String value) {
            addCriterion("zydm >=", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmLessThan(String value) {
            addCriterion("zydm <", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmLessThanOrEqualTo(String value) {
            addCriterion("zydm <=", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmLike(String value) {
            addCriterion("zydm like", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmNotLike(String value) {
            addCriterion("zydm not like", value, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmIn(List<String> values) {
            addCriterion("zydm in", values, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmNotIn(List<String> values) {
            addCriterion("zydm not in", values, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmBetween(String value1, String value2) {
            addCriterion("zydm between", value1, value2, "zydm");
            return (Criteria) this;
        }

        public Criteria andZydmNotBetween(String value1, String value2) {
            addCriterion("zydm not between", value1, value2, "zydm");
            return (Criteria) this;
        }

        public Criteria andZymcIsNull() {
            addCriterion("zymc is null");
            return (Criteria) this;
        }

        public Criteria andZymcIsNotNull() {
            addCriterion("zymc is not null");
            return (Criteria) this;
        }

        public Criteria andZymcEqualTo(String value) {
            addCriterion("zymc =", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcNotEqualTo(String value) {
            addCriterion("zymc <>", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcGreaterThan(String value) {
            addCriterion("zymc >", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcGreaterThanOrEqualTo(String value) {
            addCriterion("zymc >=", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcLessThan(String value) {
            addCriterion("zymc <", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcLessThanOrEqualTo(String value) {
            addCriterion("zymc <=", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcLike(String value) {
            addCriterion("zymc like", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcNotLike(String value) {
            addCriterion("zymc not like", value, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcIn(List<String> values) {
            addCriterion("zymc in", values, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcNotIn(List<String> values) {
            addCriterion("zymc not in", values, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcBetween(String value1, String value2) {
            addCriterion("zymc between", value1, value2, "zymc");
            return (Criteria) this;
        }

        public Criteria andZymcNotBetween(String value1, String value2) {
            addCriterion("zymc not between", value1, value2, "zymc");
            return (Criteria) this;
        }

        public Criteria andZkfxIsNull() {
            addCriterion("zkfx is null");
            return (Criteria) this;
        }

        public Criteria andZkfxIsNotNull() {
            addCriterion("zkfx is not null");
            return (Criteria) this;
        }

        public Criteria andZkfxEqualTo(String value) {
            addCriterion("zkfx =", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxNotEqualTo(String value) {
            addCriterion("zkfx <>", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxGreaterThan(String value) {
            addCriterion("zkfx >", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxGreaterThanOrEqualTo(String value) {
            addCriterion("zkfx >=", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxLessThan(String value) {
            addCriterion("zkfx <", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxLessThanOrEqualTo(String value) {
            addCriterion("zkfx <=", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxLike(String value) {
            addCriterion("zkfx like", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxNotLike(String value) {
            addCriterion("zkfx not like", value, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxIn(List<String> values) {
            addCriterion("zkfx in", values, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxNotIn(List<String> values) {
            addCriterion("zkfx not in", values, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxBetween(String value1, String value2) {
            addCriterion("zkfx between", value1, value2, "zkfx");
            return (Criteria) this;
        }

        public Criteria andZkfxNotBetween(String value1, String value2) {
            addCriterion("zkfx not between", value1, value2, "zkfx");
            return (Criteria) this;
        }

        public Criteria andBhzygsIsNull() {
            addCriterion("bhzygs is null");
            return (Criteria) this;
        }

        public Criteria andBhzygsIsNotNull() {
            addCriterion("bhzygs is not null");
            return (Criteria) this;
        }

        public Criteria andBhzygsEqualTo(String value) {
            addCriterion("bhzygs =", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsNotEqualTo(String value) {
            addCriterion("bhzygs <>", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsGreaterThan(String value) {
            addCriterion("bhzygs >", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsGreaterThanOrEqualTo(String value) {
            addCriterion("bhzygs >=", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsLessThan(String value) {
            addCriterion("bhzygs <", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsLessThanOrEqualTo(String value) {
            addCriterion("bhzygs <=", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsLike(String value) {
            addCriterion("bhzygs like", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsNotLike(String value) {
            addCriterion("bhzygs not like", value, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsIn(List<String> values) {
            addCriterion("bhzygs in", values, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsNotIn(List<String> values) {
            addCriterion("bhzygs not in", values, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsBetween(String value1, String value2) {
            addCriterion("bhzygs between", value1, value2, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andBhzygsNotBetween(String value1, String value2) {
            addCriterion("bhzygs not between", value1, value2, "bhzygs");
            return (Criteria) this;
        }

        public Criteria andXzIsNull() {
            addCriterion("xz is null");
            return (Criteria) this;
        }

        public Criteria andXzIsNotNull() {
            addCriterion("xz is not null");
            return (Criteria) this;
        }

        public Criteria andXzEqualTo(String value) {
            addCriterion("xz =", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotEqualTo(String value) {
            addCriterion("xz <>", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThan(String value) {
            addCriterion("xz >", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThanOrEqualTo(String value) {
            addCriterion("xz >=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThan(String value) {
            addCriterion("xz <", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThanOrEqualTo(String value) {
            addCriterion("xz <=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLike(String value) {
            addCriterion("xz like", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotLike(String value) {
            addCriterion("xz not like", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzIn(List<String> values) {
            addCriterion("xz in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotIn(List<String> values) {
            addCriterion("xz not in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzBetween(String value1, String value2) {
            addCriterion("xz between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotBetween(String value1, String value2) {
            addCriterion("xz not between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andYsxfIsNull() {
            addCriterion("ysxf is null");
            return (Criteria) this;
        }

        public Criteria andYsxfIsNotNull() {
            addCriterion("ysxf is not null");
            return (Criteria) this;
        }

        public Criteria andYsxfEqualTo(String value) {
            addCriterion("ysxf =", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfNotEqualTo(String value) {
            addCriterion("ysxf <>", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfGreaterThan(String value) {
            addCriterion("ysxf >", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfGreaterThanOrEqualTo(String value) {
            addCriterion("ysxf >=", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfLessThan(String value) {
            addCriterion("ysxf <", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfLessThanOrEqualTo(String value) {
            addCriterion("ysxf <=", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfLike(String value) {
            addCriterion("ysxf like", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfNotLike(String value) {
            addCriterion("ysxf not like", value, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfIn(List<String> values) {
            addCriterion("ysxf in", values, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfNotIn(List<String> values) {
            addCriterion("ysxf not in", values, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfBetween(String value1, String value2) {
            addCriterion("ysxf between", value1, value2, "ysxf");
            return (Criteria) this;
        }

        public Criteria andYsxfNotBetween(String value1, String value2) {
            addCriterion("ysxf not between", value1, value2, "ysxf");
            return (Criteria) this;
        }

        public Criteria andKlIsNull() {
            addCriterion("kl is null");
            return (Criteria) this;
        }

        public Criteria andKlIsNotNull() {
            addCriterion("kl is not null");
            return (Criteria) this;
        }

        public Criteria andKlEqualTo(String value) {
            addCriterion("kl =", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlNotEqualTo(String value) {
            addCriterion("kl <>", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlGreaterThan(String value) {
            addCriterion("kl >", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlGreaterThanOrEqualTo(String value) {
            addCriterion("kl >=", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlLessThan(String value) {
            addCriterion("kl <", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlLessThanOrEqualTo(String value) {
            addCriterion("kl <=", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlLike(String value) {
            addCriterion("kl like", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlNotLike(String value) {
            addCriterion("kl not like", value, "kl");
            return (Criteria) this;
        }

        public Criteria andKlIn(List<String> values) {
            addCriterion("kl in", values, "kl");
            return (Criteria) this;
        }

        public Criteria andKlNotIn(List<String> values) {
            addCriterion("kl not in", values, "kl");
            return (Criteria) this;
        }

        public Criteria andKlBetween(String value1, String value2) {
            addCriterion("kl between", value1, value2, "kl");
            return (Criteria) this;
        }

        public Criteria andKlNotBetween(String value1, String value2) {
            addCriterion("kl not between", value1, value2, "kl");
            return (Criteria) this;
        }

        public Criteria andZsjhIsNull() {
            addCriterion("zsjh is null");
            return (Criteria) this;
        }

        public Criteria andZsjhIsNotNull() {
            addCriterion("zsjh is not null");
            return (Criteria) this;
        }

        public Criteria andZsjhEqualTo(String value) {
            addCriterion("zsjh =", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhNotEqualTo(String value) {
            addCriterion("zsjh <>", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhGreaterThan(String value) {
            addCriterion("zsjh >", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhGreaterThanOrEqualTo(String value) {
            addCriterion("zsjh >=", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhLessThan(String value) {
            addCriterion("zsjh <", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhLessThanOrEqualTo(String value) {
            addCriterion("zsjh <=", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhLike(String value) {
            addCriterion("zsjh like", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhNotLike(String value) {
            addCriterion("zsjh not like", value, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhIn(List<String> values) {
            addCriterion("zsjh in", values, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhNotIn(List<String> values) {
            addCriterion("zsjh not in", values, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhBetween(String value1, String value2) {
            addCriterion("zsjh between", value1, value2, "zsjh");
            return (Criteria) this;
        }

        public Criteria andZsjhNotBetween(String value1, String value2) {
            addCriterion("zsjh not between", value1, value2, "zsjh");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}