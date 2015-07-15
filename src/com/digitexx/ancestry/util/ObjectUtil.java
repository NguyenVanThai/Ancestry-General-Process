/**
 * 
 */
package com.digitexx.ancestry.util;
import java.math.BigDecimal;
/**
 * @author lqnhu
 *
 */
public final class ObjectUtil{

    private ObjectUtil(){}

    public final static Boolean equalsNotNull(Object object,Object object2){
            return (Validator.isNotNull(object) && Validator.isNotNull(object2) && object.equals(object2));
    }

    public final static Boolean equals(Object object,Object object2,boolean flag_nullType){
            if (object == object2){
                    return true;
            }
            if (null == object){
                    if (flag_nullType){
                            if ("".equals(object2.toString().trim())){
                                    return true;
                            }
                    }
            }else{
                    if ("".equals(object.toString().trim())){
                            if (null == object2){
                                    if (flag_nullType){
                                            return true;
                                    }
                            }else{
                                    if ("".equals(object2.toString().trim())){
                                            return true;
                                    }
                            }
                    }else{
                            return object.equals(object2);
                    }
            }
            return false;
    }

    public final static Boolean equals(Object object,Object object2){
            return equals(object, object2, false);
    }

    public final static Boolean isBoolean(Object object){
            return object instanceof Boolean;
    }

    public final static Boolean isInteger(Object object){
            return object instanceof Integer;
    }

    public final static Boolean toBoolean(Object object){
            if (null == object){
                    throw new IllegalArgumentException("object can't be null/empty!");
            }
            return Boolean.parseBoolean(object.toString());
    }


    public final static Integer toInteger(Object value){
            Integer returnValue = null;
            if (Validator.isNotNull(value)){
                    // Integer
                    if (value instanceof Integer){
                            returnValue = (Integer) value;
                    }else{
                            try{
                                    returnValue = new Integer(value.toString().trim());
                            }catch (Exception e){
                                    throw new IllegalArgumentException("Input param:\"" + value + "\", convert to integer exception");
                            }
                    }
            }
            return returnValue;
    }

    public final static BigDecimal toBigDecimal(Object value){
            BigDecimal returnValue = null;
            if (Validator.isNotNull(value)){
                    if (value instanceof BigDecimal){
                            returnValue = (BigDecimal) value;
                    }else{
                            returnValue = new BigDecimal(value.toString().trim());
                    }
            }
            return returnValue;
    }

    public final static Long toLong(Object value){
            if (Validator.isNotNull(value)){
                    if (value instanceof Long){
                            return (Long) value;
                    }
                    return Long.parseLong(value.toString());
            }
            return null;
    }

    public final static Double toDouble(Object value){
            if (Validator.isNotNull(value)){
                    if (value instanceof Double){
                            return (Double) value;
                    }
                    return new Double(value.toString());
            }
            return null;
    }

    public final static Float toFloat(Object value){
            if (Validator.isNotNull(value)){
                    if (value instanceof Float){
                            return (Float) value;
                    }
                    return new Float(value.toString());
            }
            return null;
    }

    public final static Short toShort(Object value){
            if (Validator.isNotNull(value)){
                    if (value instanceof Short){
                            return (Short) value;
                    }
                    return new Short(value.toString());
            }
            return null;
    }

    public final static String toString(Object value){
            if (null == value){
                    return null;
            }
            if (value instanceof String){
                    return (String) value;
            }
            return value.toString();
    }

    public final static <T> T toT(Object value,Class<?> class1){
            if (null == value){
                    return null;
            }
            if (class1 == String.class){
                    return (T) toString(value);
            }else if (class1 == Boolean.class){
                    return (T) toBoolean(value);
            }else if (class1 == Integer.class){
                    return (T) toInteger(value);
            }else if (class1 == BigDecimal.class){
                    return (T) toBigDecimal(value);
            }else if (class1 == Long.class){
                    return (T) toLong(value);
            }else if (class1 == Double.class){
                    return (T) toDouble(value);
            }else if (class1 == Float.class){
                    return (T) toFloat(value);
            }else if (class1 == Short.class){
                    return (T) toShort(value);
            }
            return null;
    }

    public final static String trim(Object obj){
            return obj == null ? "" : obj.toString().trim();
    }
}
