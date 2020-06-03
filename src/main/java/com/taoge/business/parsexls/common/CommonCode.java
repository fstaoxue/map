package com.taoge.business.parsexls.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created with IntelliJ IDEA.
 * User: wjq
 * Date: 14-10-13
 * Time: 下午7:03
 * To change this template use File | Settings | File Templates.
 */
public class CommonCode {

    @SuppressWarnings("rawtypes")
	public static final List<Class> CLASSLIST = new ArrayList<Class>();
    static {
        CLASSLIST.add(String.class);
        CLASSLIST.add(Integer.TYPE);
        CLASSLIST.add(Integer.class);
        CLASSLIST.add(Boolean.TYPE);
        CLASSLIST.add(Boolean.class);
        CLASSLIST.add(Long.TYPE);
        CLASSLIST.add(Long.class);
        CLASSLIST.add(Double.TYPE);
        CLASSLIST.add(Double.class);
        CLASSLIST.add(Float.TYPE);
        CLASSLIST.add(Float.class);
        CLASSLIST.add(Short.TYPE);
        CLASSLIST.add(Short.class);
        CLASSLIST.add(Byte.TYPE);
        CLASSLIST.add(Byte.class);
        CLASSLIST.add(Timestamp.class);
    }

    public static boolean isCompatibleType(Object value, Class<?> type) {
        if (value == null || type.isInstance(value)) {
            return true;
        }
        if (type.equals(Integer.TYPE) && value instanceof Integer) {
            return true;
        }
        if (type.equals(Long.TYPE) && value instanceof Long) {
            return true;
        }
        if (type.equals(Double.TYPE) && value instanceof Double) {
            return true;
        }
        if (type.equals(Float.TYPE) && value instanceof Float) {
            return true;
        }
        if (type.equals(Short.TYPE) && value instanceof Short) {
            return true;
        }
        if (type.equals(Byte.TYPE) && value instanceof Byte) {
            return true;
        }
        if (type.equals(Character.TYPE) && value instanceof Character) {
            return true;
        }

        return type.equals(Boolean.TYPE) && value instanceof Boolean;
    }


    /**
     * 转换Object至String类型
     * @param obj
     * @return
     */
    public static String toStr(Object obj) {
        return null == obj ? "" : String.valueOf(obj);
    }

    /**
     * 转换Object至String类型
     * @param obj
     * @return
     */
    public static int toInt(Object obj) {
        return null == obj ? 0 : Integer.parseInt(toStr(obj));
    }

    /**
     * 转换Object至String类型
     * @param obj
     * @return
     */
    public static long toLong(Object obj) {
        if(obj.equals("")){
            return 0L;
        }
        return null == obj ? 0l : Long.parseLong(toStr(obj));
    }

    /**
     * 转换Object至String类型
     * @param obj
     * @return
     */
    public static double toDouble(Object obj) {
        if(obj.equals("")){
            return 0d;
        }
        return null == obj ? 0d : Double.parseDouble(toStr(obj));
    }

    public static Object processColumn(ResultSet rs, int index, Class<?> propType) throws SQLException {
        if (!propType.isPrimitive() && rs.getObject(index) == null) {
            return null;
        }

        if (propType.equals(String.class)) {
            return rs.getString(index);
            //return toStr(rs.getObject(index));
        }
        if (propType.equals(Integer.TYPE) || propType.equals(Integer.class)) {
            return Integer.valueOf(rs.getInt(index));
        }
        if (propType.equals(Boolean.TYPE) || propType.equals(Boolean.class)) {
            return Boolean.valueOf(rs.getBoolean(index));
        }
        if (propType.equals(Long.TYPE) || propType.equals(Long.class)) {
            return Long.valueOf(rs.getLong(index));
        }
        if (propType.equals(Double.TYPE) || propType.equals(Double.class)) {
            return Double.valueOf(rs.getDouble(index));
        }
        if (propType.equals(Float.TYPE) || propType.equals(Float.class)) {
            return Float.valueOf(rs.getFloat(index));
        }
        if (propType.equals(Short.TYPE) || propType.equals(Short.class)) {
            return Short.valueOf(rs.getShort(index));
        }
        if (propType.equals(Byte.TYPE) || propType.equals(Byte.class)) {
            return Byte.valueOf(rs.getByte(index));
        }
        if (propType.equals(Timestamp.class)) {
            return rs.getTimestamp(index);
        }

        return rs.getObject(index);
    }

    public static Object processColumn(Object arg, Class<?> propType) throws SQLException {
        if (!propType.isPrimitive() && arg == null) {
            return null;
        }

        if (propType.equals(String.class)) {
            return toStr(arg);
        }
        if (propType.equals(Integer.TYPE) || propType.equals(Integer.class)) {
            return toInt(arg);
        }
        if (propType.equals(Boolean.TYPE) || propType.equals(Boolean.class)) {
            return Boolean.parseBoolean(String.valueOf(arg));
        }
        if (propType.equals(Long.TYPE) || propType.equals(Long.class)) {
            return toLong(arg);
        }
        if (propType.equals(Double.TYPE) || propType.equals(Double.class)) {
            return toDouble(arg);
        }
        if (propType.equals(Float.TYPE) || propType.equals(Float.class)) {
            return Float.parseFloat(String.valueOf(arg));
        }
        if (propType.equals(Short.TYPE) || propType.equals(Short.class)) {
            return Short.parseShort(String.valueOf(arg));
        }
        if (propType.equals(Byte.TYPE) || propType.equals(Byte.class)) {
            return Byte.parseByte(String.valueOf(arg));
        }
        if (propType.equals(Timestamp.class)) {
            return Timestamp.valueOf(String.valueOf(arg));
        }

        return arg;
    }

    public static String fillSql(String sql, Object[] params) throws SQLException {
        int qmCount = 0;
        for (byte b : sql.getBytes()) {
            if ('?' == b) {
                qmCount++;
            }
        }
        int paramsCount = params == null ? 0 : params.length;

        if (0 == qmCount) {
            return sql;
        }
        if (0 == paramsCount) {
            sql = sql.replaceAll("\\?", "");
            return sql;
        }

        if (qmCount != paramsCount) {
            throw new SQLException("Wrong number of parameters: expected " + qmCount + ", was given " + paramsCount);
        }

        for (Object param : params) {
            if (null != param) {
                String s = Matcher.quoteReplacement(param.toString());
                sql = sql.replaceFirst("\\?", s);
            } else {
                sql = sql.replaceFirst("\\?", "");
            }
        }

        return sql;
    }

    public static String todayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }

}
