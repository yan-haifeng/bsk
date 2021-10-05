package com.zime.bsk.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CakeOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CakeOrderInfoExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderCaridIsNull() {
            addCriterion("order_carid is null");
            return (Criteria) this;
        }

        public Criteria andOrderCaridIsNotNull() {
            addCriterion("order_carid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCaridEqualTo(String value) {
            addCriterion("order_carid =", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridNotEqualTo(String value) {
            addCriterion("order_carid <>", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridGreaterThan(String value) {
            addCriterion("order_carid >", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridGreaterThanOrEqualTo(String value) {
            addCriterion("order_carid >=", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridLessThan(String value) {
            addCriterion("order_carid <", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridLessThanOrEqualTo(String value) {
            addCriterion("order_carid <=", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridLike(String value) {
            addCriterion("order_carid like", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridNotLike(String value) {
            addCriterion("order_carid not like", value, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridIn(List<String> values) {
            addCriterion("order_carid in", values, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridNotIn(List<String> values) {
            addCriterion("order_carid not in", values, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridBetween(String value1, String value2) {
            addCriterion("order_carid between", value1, value2, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderCaridNotBetween(String value1, String value2) {
            addCriterion("order_carid not between", value1, value2, "orderCarid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNull() {
            addCriterion("order_userid is null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNotNull() {
            addCriterion("order_userid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridEqualTo(Integer value) {
            addCriterion("order_userid =", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotEqualTo(Integer value) {
            addCriterion("order_userid <>", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThan(Integer value) {
            addCriterion("order_userid >", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_userid >=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThan(Integer value) {
            addCriterion("order_userid <", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThanOrEqualTo(Integer value) {
            addCriterion("order_userid <=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIn(List<Integer> values) {
            addCriterion("order_userid in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotIn(List<Integer> values) {
            addCriterion("order_userid not in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridBetween(Integer value1, Integer value2) {
            addCriterion("order_userid between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("order_userid not between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Double value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Double value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Double value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Double value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Double value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Double> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Double> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Double value1, Double value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Double value1, Double value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIsNull() {
            addCriterion("order_discount is null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIsNotNull() {
            addCriterion("order_discount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountEqualTo(Double value) {
            addCriterion("order_discount =", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotEqualTo(Double value) {
            addCriterion("order_discount <>", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountGreaterThan(Double value) {
            addCriterion("order_discount >", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("order_discount >=", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountLessThan(Double value) {
            addCriterion("order_discount <", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountLessThanOrEqualTo(Double value) {
            addCriterion("order_discount <=", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIn(List<Double> values) {
            addCriterion("order_discount in", values, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotIn(List<Double> values) {
            addCriterion("order_discount not in", values, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountBetween(Double value1, Double value2) {
            addCriterion("order_discount between", value1, value2, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotBetween(Double value1, Double value2) {
            addCriterion("order_discount not between", value1, value2, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidIsNull() {
            addCriterion("order_addressid is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidIsNotNull() {
            addCriterion("order_addressid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidEqualTo(Integer value) {
            addCriterion("order_addressid =", value, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidNotEqualTo(Integer value) {
            addCriterion("order_addressid <>", value, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidGreaterThan(Integer value) {
            addCriterion("order_addressid >", value, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_addressid >=", value, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidLessThan(Integer value) {
            addCriterion("order_addressid <", value, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidLessThanOrEqualTo(Integer value) {
            addCriterion("order_addressid <=", value, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidIn(List<Integer> values) {
            addCriterion("order_addressid in", values, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidNotIn(List<Integer> values) {
            addCriterion("order_addressid not in", values, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidBetween(Integer value1, Integer value2) {
            addCriterion("order_addressid between", value1, value2, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderAddressidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_addressid not between", value1, value2, "orderAddressid");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeIsNull() {
            addCriterion("order_deliverytime is null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeIsNotNull() {
            addCriterion("order_deliverytime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeEqualTo(String value) {
            addCriterion("order_deliverytime =", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeNotEqualTo(String value) {
            addCriterion("order_deliverytime <>", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeGreaterThan(String value) {
            addCriterion("order_deliverytime >", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_deliverytime >=", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeLessThan(String value) {
            addCriterion("order_deliverytime <", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeLessThanOrEqualTo(String value) {
            addCriterion("order_deliverytime <=", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeLike(String value) {
            addCriterion("order_deliverytime like", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeNotLike(String value) {
            addCriterion("order_deliverytime not like", value, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeIn(List<String> values) {
            addCriterion("order_deliverytime in", values, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeNotIn(List<String> values) {
            addCriterion("order_deliverytime not in", values, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeBetween(String value1, String value2) {
            addCriterion("order_deliverytime between", value1, value2, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliverytimeNotBetween(String value1, String value2) {
            addCriterion("order_deliverytime not between", value1, value2, "orderDeliverytime");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageIsNull() {
            addCriterion("order_carriage is null");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageIsNotNull() {
            addCriterion("order_carriage is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageEqualTo(Integer value) {
            addCriterion("order_carriage =", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageNotEqualTo(Integer value) {
            addCriterion("order_carriage <>", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageGreaterThan(Integer value) {
            addCriterion("order_carriage >", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_carriage >=", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageLessThan(Integer value) {
            addCriterion("order_carriage <", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageLessThanOrEqualTo(Integer value) {
            addCriterion("order_carriage <=", value, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageIn(List<Integer> values) {
            addCriterion("order_carriage in", values, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageNotIn(List<Integer> values) {
            addCriterion("order_carriage not in", values, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageBetween(Integer value1, Integer value2) {
            addCriterion("order_carriage between", value1, value2, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderCarriageNotBetween(Integer value1, Integer value2) {
            addCriterion("order_carriage not between", value1, value2, "orderCarriage");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
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