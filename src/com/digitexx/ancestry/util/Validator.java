/**
 * 
 */
package com.digitexx.ancestry.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lqnhu
 *
 */
public final class Validator{

    /** Don't let anyone instantiate this class. */
    private Validator(){}

    /*************************************************************************************************************/

    public final static boolean isNullOrEmpty(Object value){
            if (null == value){
                    return true;
            }
            /*****************************************************************************/
            boolean flag = false;
            if (value instanceof Collection){
                    flag = ((Collection) value).isEmpty();
            }
            // map
            else if (value instanceof Map){
                    flag = ((Map) value).isEmpty();
            }
            // Object[]object数组
            else if (value instanceof Object[]){
                    flag = ((Object[]) value).length == 0;
            }
            else if (value instanceof String){
                    flag = value.toString().trim().length() <= 0;
            }
            else if (value instanceof Enumeration){
                    flag = !((Enumeration) value).hasMoreElements();
            }
            else if (value instanceof Iterator){
                    flag = !((Iterator) value).hasNext();
            }
            return flag;
    }

    public final static boolean isNotNullOrEmpty(Object value){
            return !isNullOrEmpty(value);
    }

    public final static boolean isNull(Object value){
            return isNullOrEmpty(value);
    }

    public final static boolean isNotNull(Object value){
            return isNotNullOrEmpty(value);
    }

    public final static boolean isSpecificNumber(Object value,String specificNumber){
            boolean flag = false;
            if (isNotNullOrEmpty(value)){
                    String valueString = value.toString();
                    // Number /String
                    if (value instanceof Number || value instanceof String){
                            BigDecimal bigDecimal = new BigDecimal(valueString);
                            int i = bigDecimal.compareTo(new BigDecimal(specificNumber));
                            flag = (i == 0);
                    }
            }
            if (!flag){
                    // String format = StringUtil.format("value is :%s,but specificNumber is %s", value, specificNumber);
                    // log.debug(format);
            }
            return flag;
    }
}

