package ljj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceSaveDirExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceSaveDirExample() {
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

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceID is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceID is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Integer value) {
            addCriterion("deviceID =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Integer value) {
            addCriterion("deviceID <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Integer value) {
            addCriterion("deviceID >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceID >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Integer value) {
            addCriterion("deviceID <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Integer value) {
            addCriterion("deviceID <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Integer> values) {
            addCriterion("deviceID in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Integer> values) {
            addCriterion("deviceID not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Integer value1, Integer value2) {
            addCriterion("deviceID between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceID not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDiridIsNull() {
            addCriterion("dirID is null");
            return (Criteria) this;
        }

        public Criteria andDiridIsNotNull() {
            addCriterion("dirID is not null");
            return (Criteria) this;
        }

        public Criteria andDiridEqualTo(Integer value) {
            addCriterion("dirID =", value, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridNotEqualTo(Integer value) {
            addCriterion("dirID <>", value, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridGreaterThan(Integer value) {
            addCriterion("dirID >", value, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridGreaterThanOrEqualTo(Integer value) {
            addCriterion("dirID >=", value, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridLessThan(Integer value) {
            addCriterion("dirID <", value, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridLessThanOrEqualTo(Integer value) {
            addCriterion("dirID <=", value, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridIn(List<Integer> values) {
            addCriterion("dirID in", values, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridNotIn(List<Integer> values) {
            addCriterion("dirID not in", values, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridBetween(Integer value1, Integer value2) {
            addCriterion("dirID between", value1, value2, "dirid");
            return (Criteria) this;
        }

        public Criteria andDiridNotBetween(Integer value1, Integer value2) {
            addCriterion("dirID not between", value1, value2, "dirid");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeIsNull() {
            addCriterion("lastModifiedTime is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeIsNotNull() {
            addCriterion("lastModifiedTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeEqualTo(Date value) {
            addCriterion("lastModifiedTime =", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotEqualTo(Date value) {
            addCriterion("lastModifiedTime <>", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeGreaterThan(Date value) {
            addCriterion("lastModifiedTime >", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastModifiedTime >=", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeLessThan(Date value) {
            addCriterion("lastModifiedTime <", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeLessThanOrEqualTo(Date value) {
            addCriterion("lastModifiedTime <=", value, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeIn(List<Date> values) {
            addCriterion("lastModifiedTime in", values, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotIn(List<Date> values) {
            addCriterion("lastModifiedTime not in", values, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeBetween(Date value1, Date value2) {
            addCriterion("lastModifiedTime between", value1, value2, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedtimeNotBetween(Date value1, Date value2) {
            addCriterion("lastModifiedTime not between", value1, value2, "lastmodifiedtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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