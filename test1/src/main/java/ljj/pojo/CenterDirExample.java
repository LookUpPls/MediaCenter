package ljj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CenterDirExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CenterDirExample() {
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

        public Criteria andUriIsNull() {
            addCriterion("URI is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("URI is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("URI =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("URI <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("URI >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("URI >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("URI <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("URI <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("URI like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("URI not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("URI in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("URI not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("URI between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("URI not between", value1, value2, "uri");
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

        public Criteria andFilecountIsNull() {
            addCriterion("fileCount is null");
            return (Criteria) this;
        }

        public Criteria andFilecountIsNotNull() {
            addCriterion("fileCount is not null");
            return (Criteria) this;
        }

        public Criteria andFilecountEqualTo(Integer value) {
            addCriterion("fileCount =", value, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountNotEqualTo(Integer value) {
            addCriterion("fileCount <>", value, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountGreaterThan(Integer value) {
            addCriterion("fileCount >", value, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fileCount >=", value, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountLessThan(Integer value) {
            addCriterion("fileCount <", value, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountLessThanOrEqualTo(Integer value) {
            addCriterion("fileCount <=", value, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountIn(List<Integer> values) {
            addCriterion("fileCount in", values, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountNotIn(List<Integer> values) {
            addCriterion("fileCount not in", values, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountBetween(Integer value1, Integer value2) {
            addCriterion("fileCount between", value1, value2, "filecount");
            return (Criteria) this;
        }

        public Criteria andFilecountNotBetween(Integer value1, Integer value2) {
            addCriterion("fileCount not between", value1, value2, "filecount");
            return (Criteria) this;
        }

        public Criteria andSpacesizeIsNull() {
            addCriterion("spaceSize is null");
            return (Criteria) this;
        }

        public Criteria andSpacesizeIsNotNull() {
            addCriterion("spaceSize is not null");
            return (Criteria) this;
        }

        public Criteria andSpacesizeEqualTo(Integer value) {
            addCriterion("spaceSize =", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeNotEqualTo(Integer value) {
            addCriterion("spaceSize <>", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeGreaterThan(Integer value) {
            addCriterion("spaceSize >", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("spaceSize >=", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeLessThan(Integer value) {
            addCriterion("spaceSize <", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeLessThanOrEqualTo(Integer value) {
            addCriterion("spaceSize <=", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeIn(List<Integer> values) {
            addCriterion("spaceSize in", values, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeNotIn(List<Integer> values) {
            addCriterion("spaceSize not in", values, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeBetween(Integer value1, Integer value2) {
            addCriterion("spaceSize between", value1, value2, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeNotBetween(Integer value1, Integer value2) {
            addCriterion("spaceSize not between", value1, value2, "spacesize");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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