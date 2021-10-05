package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.List;

public class CakeSpecsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeSpecsExample() {
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

        public Criteria andCakespecsIdIsNull() {
            addCriterion("cakespecs_id is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdIsNotNull() {
            addCriterion("cakespecs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdEqualTo(Integer value) {
            addCriterion("cakespecs_id =", value, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdNotEqualTo(Integer value) {
            addCriterion("cakespecs_id <>", value, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdGreaterThan(Integer value) {
            addCriterion("cakespecs_id >", value, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cakespecs_id >=", value, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdLessThan(Integer value) {
            addCriterion("cakespecs_id <", value, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdLessThanOrEqualTo(Integer value) {
            addCriterion("cakespecs_id <=", value, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdIn(List<Integer> values) {
            addCriterion("cakespecs_id in", values, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdNotIn(List<Integer> values) {
            addCriterion("cakespecs_id not in", values, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdBetween(Integer value1, Integer value2) {
            addCriterion("cakespecs_id between", value1, value2, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cakespecs_id not between", value1, value2, "cakespecsId");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidIsNull() {
            addCriterion("cakespecs_cakeid is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidIsNotNull() {
            addCriterion("cakespecs_cakeid is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidEqualTo(Integer value) {
            addCriterion("cakespecs_cakeid =", value, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidNotEqualTo(Integer value) {
            addCriterion("cakespecs_cakeid <>", value, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidGreaterThan(Integer value) {
            addCriterion("cakespecs_cakeid >", value, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cakespecs_cakeid >=", value, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidLessThan(Integer value) {
            addCriterion("cakespecs_cakeid <", value, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidLessThanOrEqualTo(Integer value) {
            addCriterion("cakespecs_cakeid <=", value, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidIn(List<Integer> values) {
            addCriterion("cakespecs_cakeid in", values, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidNotIn(List<Integer> values) {
            addCriterion("cakespecs_cakeid not in", values, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidBetween(Integer value1, Integer value2) {
            addCriterion("cakespecs_cakeid between", value1, value2, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsCakeidNotBetween(Integer value1, Integer value2) {
            addCriterion("cakespecs_cakeid not between", value1, value2, "cakespecsCakeid");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameIsNull() {
            addCriterion("cakespecs_name is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameIsNotNull() {
            addCriterion("cakespecs_name is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameEqualTo(String value) {
            addCriterion("cakespecs_name =", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameNotEqualTo(String value) {
            addCriterion("cakespecs_name <>", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameGreaterThan(String value) {
            addCriterion("cakespecs_name >", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameGreaterThanOrEqualTo(String value) {
            addCriterion("cakespecs_name >=", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameLessThan(String value) {
            addCriterion("cakespecs_name <", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameLessThanOrEqualTo(String value) {
            addCriterion("cakespecs_name <=", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameLike(String value) {
            addCriterion("cakespecs_name like", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameNotLike(String value) {
            addCriterion("cakespecs_name not like", value, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameIn(List<String> values) {
            addCriterion("cakespecs_name in", values, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameNotIn(List<String> values) {
            addCriterion("cakespecs_name not in", values, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameBetween(String value1, String value2) {
            addCriterion("cakespecs_name between", value1, value2, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsNameNotBetween(String value1, String value2) {
            addCriterion("cakespecs_name not between", value1, value2, "cakespecsName");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceIsNull() {
            addCriterion("cakespecs_price is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceIsNotNull() {
            addCriterion("cakespecs_price is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceEqualTo(Double value) {
            addCriterion("cakespecs_price =", value, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceNotEqualTo(Double value) {
            addCriterion("cakespecs_price <>", value, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceGreaterThan(Double value) {
            addCriterion("cakespecs_price >", value, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("cakespecs_price >=", value, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceLessThan(Double value) {
            addCriterion("cakespecs_price <", value, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceLessThanOrEqualTo(Double value) {
            addCriterion("cakespecs_price <=", value, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceIn(List<Double> values) {
            addCriterion("cakespecs_price in", values, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceNotIn(List<Double> values) {
            addCriterion("cakespecs_price not in", values, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceBetween(Double value1, Double value2) {
            addCriterion("cakespecs_price between", value1, value2, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsPriceNotBetween(Double value1, Double value2) {
            addCriterion("cakespecs_price not between", value1, value2, "cakespecsPrice");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetIsNull() {
            addCriterion("cakespecs_sweet is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetIsNotNull() {
            addCriterion("cakespecs_sweet is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetEqualTo(Integer value) {
            addCriterion("cakespecs_sweet =", value, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetNotEqualTo(Integer value) {
            addCriterion("cakespecs_sweet <>", value, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetGreaterThan(Integer value) {
            addCriterion("cakespecs_sweet >", value, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetGreaterThanOrEqualTo(Integer value) {
            addCriterion("cakespecs_sweet >=", value, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetLessThan(Integer value) {
            addCriterion("cakespecs_sweet <", value, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetLessThanOrEqualTo(Integer value) {
            addCriterion("cakespecs_sweet <=", value, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetIn(List<Integer> values) {
            addCriterion("cakespecs_sweet in", values, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetNotIn(List<Integer> values) {
            addCriterion("cakespecs_sweet not in", values, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetBetween(Integer value1, Integer value2) {
            addCriterion("cakespecs_sweet between", value1, value2, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSweetNotBetween(Integer value1, Integer value2) {
            addCriterion("cakespecs_sweet not between", value1, value2, "cakespecsSweet");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeIsNull() {
            addCriterion("cakespecs_size is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeIsNotNull() {
            addCriterion("cakespecs_size is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeEqualTo(String value) {
            addCriterion("cakespecs_size =", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeNotEqualTo(String value) {
            addCriterion("cakespecs_size <>", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeGreaterThan(String value) {
            addCriterion("cakespecs_size >", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeGreaterThanOrEqualTo(String value) {
            addCriterion("cakespecs_size >=", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeLessThan(String value) {
            addCriterion("cakespecs_size <", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeLessThanOrEqualTo(String value) {
            addCriterion("cakespecs_size <=", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeLike(String value) {
            addCriterion("cakespecs_size like", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeNotLike(String value) {
            addCriterion("cakespecs_size not like", value, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeIn(List<String> values) {
            addCriterion("cakespecs_size in", values, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeNotIn(List<String> values) {
            addCriterion("cakespecs_size not in", values, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeBetween(String value1, String value2) {
            addCriterion("cakespecs_size between", value1, value2, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsSizeNotBetween(String value1, String value2) {
            addCriterion("cakespecs_size not between", value1, value2, "cakespecsSize");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonIsNull() {
            addCriterion("cakespecs_person is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonIsNotNull() {
            addCriterion("cakespecs_person is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonEqualTo(String value) {
            addCriterion("cakespecs_person =", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonNotEqualTo(String value) {
            addCriterion("cakespecs_person <>", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonGreaterThan(String value) {
            addCriterion("cakespecs_person >", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonGreaterThanOrEqualTo(String value) {
            addCriterion("cakespecs_person >=", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonLessThan(String value) {
            addCriterion("cakespecs_person <", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonLessThanOrEqualTo(String value) {
            addCriterion("cakespecs_person <=", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonLike(String value) {
            addCriterion("cakespecs_person like", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonNotLike(String value) {
            addCriterion("cakespecs_person not like", value, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonIn(List<String> values) {
            addCriterion("cakespecs_person in", values, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonNotIn(List<String> values) {
            addCriterion("cakespecs_person not in", values, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonBetween(String value1, String value2) {
            addCriterion("cakespecs_person between", value1, value2, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsPersonNotBetween(String value1, String value2) {
            addCriterion("cakespecs_person not between", value1, value2, "cakespecsPerson");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareIsNull() {
            addCriterion("cakespecs_tableware is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareIsNotNull() {
            addCriterion("cakespecs_tableware is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareEqualTo(String value) {
            addCriterion("cakespecs_tableware =", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareNotEqualTo(String value) {
            addCriterion("cakespecs_tableware <>", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareGreaterThan(String value) {
            addCriterion("cakespecs_tableware >", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareGreaterThanOrEqualTo(String value) {
            addCriterion("cakespecs_tableware >=", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareLessThan(String value) {
            addCriterion("cakespecs_tableware <", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareLessThanOrEqualTo(String value) {
            addCriterion("cakespecs_tableware <=", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareLike(String value) {
            addCriterion("cakespecs_tableware like", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareNotLike(String value) {
            addCriterion("cakespecs_tableware not like", value, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareIn(List<String> values) {
            addCriterion("cakespecs_tableware in", values, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareNotIn(List<String> values) {
            addCriterion("cakespecs_tableware not in", values, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareBetween(String value1, String value2) {
            addCriterion("cakespecs_tableware between", value1, value2, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTablewareNotBetween(String value1, String value2) {
            addCriterion("cakespecs_tableware not between", value1, value2, "cakespecsTableware");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeIsNull() {
            addCriterion("cakespecs_time is null");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeIsNotNull() {
            addCriterion("cakespecs_time is not null");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeEqualTo(String value) {
            addCriterion("cakespecs_time =", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeNotEqualTo(String value) {
            addCriterion("cakespecs_time <>", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeGreaterThan(String value) {
            addCriterion("cakespecs_time >", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeGreaterThanOrEqualTo(String value) {
            addCriterion("cakespecs_time >=", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeLessThan(String value) {
            addCriterion("cakespecs_time <", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeLessThanOrEqualTo(String value) {
            addCriterion("cakespecs_time <=", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeLike(String value) {
            addCriterion("cakespecs_time like", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeNotLike(String value) {
            addCriterion("cakespecs_time not like", value, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeIn(List<String> values) {
            addCriterion("cakespecs_time in", values, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeNotIn(List<String> values) {
            addCriterion("cakespecs_time not in", values, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeBetween(String value1, String value2) {
            addCriterion("cakespecs_time between", value1, value2, "cakespecsTime");
            return (Criteria) this;
        }

        public Criteria andCakespecsTimeNotBetween(String value1, String value2) {
            addCriterion("cakespecs_time not between", value1, value2, "cakespecsTime");
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