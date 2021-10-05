package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.List;

public class CakeClassMinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeClassMinExample() {
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

        public Criteria andCakeclassminIdIsNull() {
            addCriterion("cakeclassmin_id is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdIsNotNull() {
            addCriterion("cakeclassmin_id is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdEqualTo(Integer value) {
            addCriterion("cakeclassmin_id =", value, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdNotEqualTo(Integer value) {
            addCriterion("cakeclassmin_id <>", value, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdGreaterThan(Integer value) {
            addCriterion("cakeclassmin_id >", value, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cakeclassmin_id >=", value, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdLessThan(Integer value) {
            addCriterion("cakeclassmin_id <", value, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdLessThanOrEqualTo(Integer value) {
            addCriterion("cakeclassmin_id <=", value, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdIn(List<Integer> values) {
            addCriterion("cakeclassmin_id in", values, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdNotIn(List<Integer> values) {
            addCriterion("cakeclassmin_id not in", values, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdBetween(Integer value1, Integer value2) {
            addCriterion("cakeclassmin_id between", value1, value2, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cakeclassmin_id not between", value1, value2, "cakeclassminId");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidIsNull() {
            addCriterion("cakeclassmin_classid is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidIsNotNull() {
            addCriterion("cakeclassmin_classid is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidEqualTo(Integer value) {
            addCriterion("cakeclassmin_classid =", value, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidNotEqualTo(Integer value) {
            addCriterion("cakeclassmin_classid <>", value, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidGreaterThan(Integer value) {
            addCriterion("cakeclassmin_classid >", value, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cakeclassmin_classid >=", value, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidLessThan(Integer value) {
            addCriterion("cakeclassmin_classid <", value, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidLessThanOrEqualTo(Integer value) {
            addCriterion("cakeclassmin_classid <=", value, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidIn(List<Integer> values) {
            addCriterion("cakeclassmin_classid in", values, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidNotIn(List<Integer> values) {
            addCriterion("cakeclassmin_classid not in", values, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidBetween(Integer value1, Integer value2) {
            addCriterion("cakeclassmin_classid between", value1, value2, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("cakeclassmin_classid not between", value1, value2, "cakeclassminClassid");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameIsNull() {
            addCriterion("cakeclassmin_name is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameIsNotNull() {
            addCriterion("cakeclassmin_name is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameEqualTo(String value) {
            addCriterion("cakeclassmin_name =", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameNotEqualTo(String value) {
            addCriterion("cakeclassmin_name <>", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameGreaterThan(String value) {
            addCriterion("cakeclassmin_name >", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameGreaterThanOrEqualTo(String value) {
            addCriterion("cakeclassmin_name >=", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameLessThan(String value) {
            addCriterion("cakeclassmin_name <", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameLessThanOrEqualTo(String value) {
            addCriterion("cakeclassmin_name <=", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameLike(String value) {
            addCriterion("cakeclassmin_name like", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameNotLike(String value) {
            addCriterion("cakeclassmin_name not like", value, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameIn(List<String> values) {
            addCriterion("cakeclassmin_name in", values, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameNotIn(List<String> values) {
            addCriterion("cakeclassmin_name not in", values, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameBetween(String value1, String value2) {
            addCriterion("cakeclassmin_name between", value1, value2, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminNameNotBetween(String value1, String value2) {
            addCriterion("cakeclassmin_name not between", value1, value2, "cakeclassminName");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoIsNull() {
            addCriterion("cakeclassmin_info is null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoIsNotNull() {
            addCriterion("cakeclassmin_info is not null");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoEqualTo(String value) {
            addCriterion("cakeclassmin_info =", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoNotEqualTo(String value) {
            addCriterion("cakeclassmin_info <>", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoGreaterThan(String value) {
            addCriterion("cakeclassmin_info >", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoGreaterThanOrEqualTo(String value) {
            addCriterion("cakeclassmin_info >=", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoLessThan(String value) {
            addCriterion("cakeclassmin_info <", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoLessThanOrEqualTo(String value) {
            addCriterion("cakeclassmin_info <=", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoLike(String value) {
            addCriterion("cakeclassmin_info like", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoNotLike(String value) {
            addCriterion("cakeclassmin_info not like", value, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoIn(List<String> values) {
            addCriterion("cakeclassmin_info in", values, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoNotIn(List<String> values) {
            addCriterion("cakeclassmin_info not in", values, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoBetween(String value1, String value2) {
            addCriterion("cakeclassmin_info between", value1, value2, "cakeclassminInfo");
            return (Criteria) this;
        }

        public Criteria andCakeclassminInfoNotBetween(String value1, String value2) {
            addCriterion("cakeclassmin_info not between", value1, value2, "cakeclassminInfo");
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