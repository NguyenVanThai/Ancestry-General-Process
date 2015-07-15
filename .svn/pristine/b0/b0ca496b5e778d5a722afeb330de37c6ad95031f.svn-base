
package com.digitexx.ancestry.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author lqnhu
 *
 */
public class ResultSetIterator implements Iterator {

    /**
     * The wrapped <code>ResultSet</code>.
     */
    private final ResultSet rs;
    
    /**
     * The processor to use when converting a row into an Object[].
     */
    private final RowProcessor convert;

    /**
     * Constructor for ResultSetIterator.
     * @param rs Wrap this <code>ResultSet</code> in an <code>Iterator</code>.
     */
    public ResultSetIterator(ResultSet rs) {
        this(rs , new BasicRowProcessor());
    }
    
    /**
     * Constructor for ResultSetIterator.
     * @param rs Wrap this <code>ResultSet</code> in an <code>Iterator</code>.
     * @param convert The processor to use when converting a row into an 
     * <code>Object[]</code>.  Defaults to a 
     * <code>BasicRowProcessor</code>.
     */
    public ResultSetIterator(ResultSet rs, RowProcessor convert) {
        this.rs = rs;
        this.convert = convert;
    }

    /**
     * Returns true if there are more rows in the ResultSet.
     * @return boolean <code>true</code> if there are more rows
     * @throws RuntimeException if an SQLException occurs.
     */
    public boolean hasNext() {
        try {
            return !rs.isLast();
        } catch (SQLException e) {
            rethrow(e);
            return false;
        }
    }

    /**
     * Returns the next row as an <code>Object[]</code>.
     * @return An <code>Object[]</code> with the same number of elements as
     * columns in the <code>ResultSet</code>. 
     * @see java.util.Iterator#next()
     * @throws RuntimeException if an SQLException occurs.
     */
    public Object next() {
        try {
            rs.next();
            return this.convert.toArray(rs);
        } catch (SQLException e) {
            rethrow(e);
            return null;
        }
    }

    /**
     * Deletes the current row from the <code>ResultSet</code>.
     * @see java.util.Iterator#remove()
     * @throws RuntimeException if an SQLException occurs.
     */
    public void remove() {
        try {
            this.rs.deleteRow();
        } catch (SQLException e) {
            rethrow(e);
        }
    }

    protected void rethrow(SQLException e) {
        throw new RuntimeException(e.getMessage());
    }

}

 interface RowProcessor {
    public Object[] toArray(ResultSet rs) throws SQLException;
    public Object toBean(ResultSet rs, Class type) throws SQLException;
    public List toBeanList(ResultSet rs, Class type) throws SQLException;
    public Map toMap(ResultSet rs) throws SQLException;

}


