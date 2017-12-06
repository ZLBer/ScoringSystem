package test.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InformationExample() {
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

        public Criteria andExamNumberIsNull() {
            addCriterion("exam_number is null");
            return (Criteria) this;
        }

        public Criteria andExamNumberIsNotNull() {
            addCriterion("exam_number is not null");
            return (Criteria) this;
        }

        public Criteria andExamNumberEqualTo(String value) {
            addCriterion("exam_number =", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotEqualTo(String value) {
            addCriterion("exam_number <>", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberGreaterThan(String value) {
            addCriterion("exam_number >", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberGreaterThanOrEqualTo(String value) {
            addCriterion("exam_number >=", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberLessThan(String value) {
            addCriterion("exam_number <", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberLessThanOrEqualTo(String value) {
            addCriterion("exam_number <=", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberLike(String value) {
            addCriterion("exam_number like", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotLike(String value) {
            addCriterion("exam_number not like", value, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberIn(List<String> values) {
            addCriterion("exam_number in", values, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotIn(List<String> values) {
            addCriterion("exam_number not in", values, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberBetween(String value1, String value2) {
            addCriterion("exam_number between", value1, value2, "examNumber");
            return (Criteria) this;
        }

        public Criteria andExamNumberNotBetween(String value1, String value2) {
            addCriterion("exam_number not between", value1, value2, "examNumber");
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

        public Criteria andSerialNumberEqualTo(Integer value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(Integer value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(Integer value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(Integer value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<Integer> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<Integer> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andFacultyIsNull() {
            addCriterion("faculty is null");
            return (Criteria) this;
        }

        public Criteria andFacultyIsNotNull() {
            addCriterion("faculty is not null");
            return (Criteria) this;
        }

        public Criteria andFacultyEqualTo(String value) {
            addCriterion("faculty =", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyNotEqualTo(String value) {
            addCriterion("faculty <>", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyGreaterThan(String value) {
            addCriterion("faculty >", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyGreaterThanOrEqualTo(String value) {
            addCriterion("faculty >=", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyLessThan(String value) {
            addCriterion("faculty <", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyLessThanOrEqualTo(String value) {
            addCriterion("faculty <=", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyLike(String value) {
            addCriterion("faculty like", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyNotLike(String value) {
            addCriterion("faculty not like", value, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyIn(List<String> values) {
            addCriterion("faculty in", values, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyNotIn(List<String> values) {
            addCriterion("faculty not in", values, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyBetween(String value1, String value2) {
            addCriterion("faculty between", value1, value2, "faculty");
            return (Criteria) this;
        }

        public Criteria andFacultyNotBetween(String value1, String value2) {
            addCriterion("faculty not between", value1, value2, "faculty");
            return (Criteria) this;
        }

        public Criteria andDominantTermIsNull() {
            addCriterion("dominant_term is null");
            return (Criteria) this;
        }

        public Criteria andDominantTermIsNotNull() {
            addCriterion("dominant_term is not null");
            return (Criteria) this;
        }

        public Criteria andDominantTermEqualTo(String value) {
            addCriterion("dominant_term =", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermNotEqualTo(String value) {
            addCriterion("dominant_term <>", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermGreaterThan(String value) {
            addCriterion("dominant_term >", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermGreaterThanOrEqualTo(String value) {
            addCriterion("dominant_term >=", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermLessThan(String value) {
            addCriterion("dominant_term <", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermLessThanOrEqualTo(String value) {
            addCriterion("dominant_term <=", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermLike(String value) {
            addCriterion("dominant_term like", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermNotLike(String value) {
            addCriterion("dominant_term not like", value, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermIn(List<String> values) {
            addCriterion("dominant_term in", values, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermNotIn(List<String> values) {
            addCriterion("dominant_term not in", values, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermBetween(String value1, String value2) {
            addCriterion("dominant_term between", value1, value2, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantTermNotBetween(String value1, String value2) {
            addCriterion("dominant_term not between", value1, value2, "dominantTerm");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentIsNull() {
            addCriterion("dominant_instrument is null");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentIsNotNull() {
            addCriterion("dominant_instrument is not null");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentEqualTo(String value) {
            addCriterion("dominant_instrument =", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentNotEqualTo(String value) {
            addCriterion("dominant_instrument <>", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentGreaterThan(String value) {
            addCriterion("dominant_instrument >", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentGreaterThanOrEqualTo(String value) {
            addCriterion("dominant_instrument >=", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentLessThan(String value) {
            addCriterion("dominant_instrument <", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentLessThanOrEqualTo(String value) {
            addCriterion("dominant_instrument <=", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentLike(String value) {
            addCriterion("dominant_instrument like", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentNotLike(String value) {
            addCriterion("dominant_instrument not like", value, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentIn(List<String> values) {
            addCriterion("dominant_instrument in", values, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentNotIn(List<String> values) {
            addCriterion("dominant_instrument not in", values, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentBetween(String value1, String value2) {
            addCriterion("dominant_instrument between", value1, value2, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantInstrumentNotBetween(String value1, String value2) {
            addCriterion("dominant_instrument not between", value1, value2, "dominantInstrument");
            return (Criteria) this;
        }

        public Criteria andDominantSongIsNull() {
            addCriterion("dominant_song is null");
            return (Criteria) this;
        }

        public Criteria andDominantSongIsNotNull() {
            addCriterion("dominant_song is not null");
            return (Criteria) this;
        }

        public Criteria andDominantSongEqualTo(String value) {
            addCriterion("dominant_song =", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongNotEqualTo(String value) {
            addCriterion("dominant_song <>", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongGreaterThan(String value) {
            addCriterion("dominant_song >", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongGreaterThanOrEqualTo(String value) {
            addCriterion("dominant_song >=", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongLessThan(String value) {
            addCriterion("dominant_song <", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongLessThanOrEqualTo(String value) {
            addCriterion("dominant_song <=", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongLike(String value) {
            addCriterion("dominant_song like", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongNotLike(String value) {
            addCriterion("dominant_song not like", value, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongIn(List<String> values) {
            addCriterion("dominant_song in", values, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongNotIn(List<String> values) {
            addCriterion("dominant_song not in", values, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongBetween(String value1, String value2) {
            addCriterion("dominant_song between", value1, value2, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andDominantSongNotBetween(String value1, String value2) {
            addCriterion("dominant_song not between", value1, value2, "dominantSong");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermIsNull() {
            addCriterion("secondary_term is null");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermIsNotNull() {
            addCriterion("secondary_term is not null");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermEqualTo(String value) {
            addCriterion("secondary_term =", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermNotEqualTo(String value) {
            addCriterion("secondary_term <>", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermGreaterThan(String value) {
            addCriterion("secondary_term >", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermGreaterThanOrEqualTo(String value) {
            addCriterion("secondary_term >=", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermLessThan(String value) {
            addCriterion("secondary_term <", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermLessThanOrEqualTo(String value) {
            addCriterion("secondary_term <=", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermLike(String value) {
            addCriterion("secondary_term like", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermNotLike(String value) {
            addCriterion("secondary_term not like", value, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermIn(List<String> values) {
            addCriterion("secondary_term in", values, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermNotIn(List<String> values) {
            addCriterion("secondary_term not in", values, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermBetween(String value1, String value2) {
            addCriterion("secondary_term between", value1, value2, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryTermNotBetween(String value1, String value2) {
            addCriterion("secondary_term not between", value1, value2, "secondaryTerm");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentIsNull() {
            addCriterion("secondary_instrument is null");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentIsNotNull() {
            addCriterion("secondary_instrument is not null");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentEqualTo(String value) {
            addCriterion("secondary_instrument =", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentNotEqualTo(String value) {
            addCriterion("secondary_instrument <>", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentGreaterThan(String value) {
            addCriterion("secondary_instrument >", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentGreaterThanOrEqualTo(String value) {
            addCriterion("secondary_instrument >=", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentLessThan(String value) {
            addCriterion("secondary_instrument <", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentLessThanOrEqualTo(String value) {
            addCriterion("secondary_instrument <=", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentLike(String value) {
            addCriterion("secondary_instrument like", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentNotLike(String value) {
            addCriterion("secondary_instrument not like", value, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentIn(List<String> values) {
            addCriterion("secondary_instrument in", values, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentNotIn(List<String> values) {
            addCriterion("secondary_instrument not in", values, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentBetween(String value1, String value2) {
            addCriterion("secondary_instrument between", value1, value2, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondaryInstrumentNotBetween(String value1, String value2) {
            addCriterion("secondary_instrument not between", value1, value2, "secondaryInstrument");
            return (Criteria) this;
        }

        public Criteria andSecondarySongIsNull() {
            addCriterion("secondary_song is null");
            return (Criteria) this;
        }

        public Criteria andSecondarySongIsNotNull() {
            addCriterion("secondary_song is not null");
            return (Criteria) this;
        }

        public Criteria andSecondarySongEqualTo(String value) {
            addCriterion("secondary_song =", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongNotEqualTo(String value) {
            addCriterion("secondary_song <>", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongGreaterThan(String value) {
            addCriterion("secondary_song >", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongGreaterThanOrEqualTo(String value) {
            addCriterion("secondary_song >=", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongLessThan(String value) {
            addCriterion("secondary_song <", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongLessThanOrEqualTo(String value) {
            addCriterion("secondary_song <=", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongLike(String value) {
            addCriterion("secondary_song like", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongNotLike(String value) {
            addCriterion("secondary_song not like", value, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongIn(List<String> values) {
            addCriterion("secondary_song in", values, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongNotIn(List<String> values) {
            addCriterion("secondary_song not in", values, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongBetween(String value1, String value2) {
            addCriterion("secondary_song between", value1, value2, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSecondarySongNotBetween(String value1, String value2) {
            addCriterion("secondary_song not between", value1, value2, "secondarySong");
            return (Criteria) this;
        }

        public Criteria andSightsingingIsNull() {
            addCriterion("sightsinging is null");
            return (Criteria) this;
        }

        public Criteria andSightsingingIsNotNull() {
            addCriterion("sightsinging is not null");
            return (Criteria) this;
        }

        public Criteria andSightsingingEqualTo(String value) {
            addCriterion("sightsinging =", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingNotEqualTo(String value) {
            addCriterion("sightsinging <>", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingGreaterThan(String value) {
            addCriterion("sightsinging >", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingGreaterThanOrEqualTo(String value) {
            addCriterion("sightsinging >=", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingLessThan(String value) {
            addCriterion("sightsinging <", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingLessThanOrEqualTo(String value) {
            addCriterion("sightsinging <=", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingLike(String value) {
            addCriterion("sightsinging like", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingNotLike(String value) {
            addCriterion("sightsinging not like", value, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingIn(List<String> values) {
            addCriterion("sightsinging in", values, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingNotIn(List<String> values) {
            addCriterion("sightsinging not in", values, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingBetween(String value1, String value2) {
            addCriterion("sightsinging between", value1, value2, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andSightsingingNotBetween(String value1, String value2) {
            addCriterion("sightsinging not between", value1, value2, "sightsinging");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeIsNull() {
            addCriterion("entrance_time is null");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeIsNotNull() {
            addCriterion("entrance_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeEqualTo(Date value) {
            addCriterion("entrance_time =", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeNotEqualTo(Date value) {
            addCriterion("entrance_time <>", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeGreaterThan(Date value) {
            addCriterion("entrance_time >", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("entrance_time >=", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeLessThan(Date value) {
            addCriterion("entrance_time <", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeLessThanOrEqualTo(Date value) {
            addCriterion("entrance_time <=", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeIn(List<Date> values) {
            addCriterion("entrance_time in", values, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeNotIn(List<Date> values) {
            addCriterion("entrance_time not in", values, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeBetween(Date value1, Date value2) {
            addCriterion("entrance_time between", value1, value2, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeNotBetween(Date value1, Date value2) {
            addCriterion("entrance_time not between", value1, value2, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(Integer value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(Integer value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(Integer value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(Integer value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(Integer value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<Integer> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<Integer> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(Integer value1, Integer value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(Integer value1, Integer value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andHasExamIsNull() {
            addCriterion("hasExam is null");
            return (Criteria) this;
        }

        public Criteria andHasExamIsNotNull() {
            addCriterion("hasExam is not null");
            return (Criteria) this;
        }

        public Criteria andHasExamEqualTo(Boolean value) {
            addCriterion("hasExam =", value, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamNotEqualTo(Boolean value) {
            addCriterion("hasExam <>", value, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamGreaterThan(Boolean value) {
            addCriterion("hasExam >", value, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hasExam >=", value, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamLessThan(Boolean value) {
            addCriterion("hasExam <", value, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamLessThanOrEqualTo(Boolean value) {
            addCriterion("hasExam <=", value, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamIn(List<Boolean> values) {
            addCriterion("hasExam in", values, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamNotIn(List<Boolean> values) {
            addCriterion("hasExam not in", values, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamBetween(Boolean value1, Boolean value2) {
            addCriterion("hasExam between", value1, value2, "hasExam");
            return (Criteria) this;
        }

        public Criteria andHasExamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hasExam not between", value1, value2, "hasExam");
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