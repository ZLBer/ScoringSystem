package test.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreExample() {
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

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andDominantScoreIsNull() {
            addCriterion("dominant_score is null");
            return (Criteria) this;
        }

        public Criteria andDominantScoreIsNotNull() {
            addCriterion("dominant_score is not null");
            return (Criteria) this;
        }

        public Criteria andDominantScoreEqualTo(Integer value) {
            addCriterion("dominant_score =", value, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreNotEqualTo(Integer value) {
            addCriterion("dominant_score <>", value, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreGreaterThan(Integer value) {
            addCriterion("dominant_score >", value, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("dominant_score >=", value, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreLessThan(Integer value) {
            addCriterion("dominant_score <", value, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreLessThanOrEqualTo(Integer value) {
            addCriterion("dominant_score <=", value, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreIn(List<Integer> values) {
            addCriterion("dominant_score in", values, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreNotIn(List<Integer> values) {
            addCriterion("dominant_score not in", values, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreBetween(Integer value1, Integer value2) {
            addCriterion("dominant_score between", value1, value2, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andDominantScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("dominant_score not between", value1, value2, "dominantScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreIsNull() {
            addCriterion("secondary_score is null");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreIsNotNull() {
            addCriterion("secondary_score is not null");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreEqualTo(Integer value) {
            addCriterion("secondary_score =", value, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreNotEqualTo(Integer value) {
            addCriterion("secondary_score <>", value, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreGreaterThan(Integer value) {
            addCriterion("secondary_score >", value, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("secondary_score >=", value, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreLessThan(Integer value) {
            addCriterion("secondary_score <", value, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreLessThanOrEqualTo(Integer value) {
            addCriterion("secondary_score <=", value, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreIn(List<Integer> values) {
            addCriterion("secondary_score in", values, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreNotIn(List<Integer> values) {
            addCriterion("secondary_score not in", values, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreBetween(Integer value1, Integer value2) {
            addCriterion("secondary_score between", value1, value2, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSecondaryScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("secondary_score not between", value1, value2, "secondaryScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreIsNull() {
            addCriterion("sightsinging_score is null");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreIsNotNull() {
            addCriterion("sightsinging_score is not null");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreEqualTo(Integer value) {
            addCriterion("sightsinging_score =", value, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreNotEqualTo(Integer value) {
            addCriterion("sightsinging_score <>", value, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreGreaterThan(Integer value) {
            addCriterion("sightsinging_score >", value, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("sightsinging_score >=", value, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreLessThan(Integer value) {
            addCriterion("sightsinging_score <", value, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreLessThanOrEqualTo(Integer value) {
            addCriterion("sightsinging_score <=", value, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreIn(List<Integer> values) {
            addCriterion("sightsinging_score in", values, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreNotIn(List<Integer> values) {
            addCriterion("sightsinging_score not in", values, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreBetween(Integer value1, Integer value2) {
            addCriterion("sightsinging_score between", value1, value2, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andSightsingingScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("sightsinging_score not between", value1, value2, "sightsingingScore");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNull() {
            addCriterion("reviewer is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNotNull() {
            addCriterion("reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerEqualTo(String value) {
            addCriterion("reviewer =", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotEqualTo(String value) {
            addCriterion("reviewer <>", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThan(String value) {
            addCriterion("reviewer >", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("reviewer >=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThan(String value) {
            addCriterion("reviewer <", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThanOrEqualTo(String value) {
            addCriterion("reviewer <=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLike(String value) {
            addCriterion("reviewer like", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotLike(String value) {
            addCriterion("reviewer not like", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerIn(List<String> values) {
            addCriterion("reviewer in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotIn(List<String> values) {
            addCriterion("reviewer not in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerBetween(String value1, String value2) {
            addCriterion("reviewer between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotBetween(String value1, String value2) {
            addCriterion("reviewer not between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNull() {
            addCriterion("score_time is null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNotNull() {
            addCriterion("score_time is not null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeEqualTo(Date value) {
            addCriterion("score_time =", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotEqualTo(Date value) {
            addCriterion("score_time <>", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThan(Date value) {
            addCriterion("score_time >", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("score_time >=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThan(Date value) {
            addCriterion("score_time <", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThanOrEqualTo(Date value) {
            addCriterion("score_time <=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIn(List<Date> values) {
            addCriterion("score_time in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotIn(List<Date> values) {
            addCriterion("score_time not in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeBetween(Date value1, Date value2) {
            addCriterion("score_time between", value1, value2, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotBetween(Date value1, Date value2) {
            addCriterion("score_time not between", value1, value2, "scoreTime");
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