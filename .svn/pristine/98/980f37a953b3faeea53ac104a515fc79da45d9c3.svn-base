package com.digitexx.ancestry.db;

import java.util.List;

/**
 * @author lqnhu
 *
 */
public abstract class AbstractSqlBuilder {

    protected void appendList(StringBuilder stringBuilder, List<String> list, String init, String separator) {
        boolean flag = true;
        for (String item : list) {
            if (flag) {
                stringBuilder.append(init);
            } else {
                stringBuilder.append(separator);
            }
            flag = false;
            stringBuilder.append(item);
        }
    }
}
