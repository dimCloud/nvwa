package org.dimcloud.nvwa.ddd.domain;

/**
 * entity identifier
 *
 * @author hehe
 * @since 1.0.0
 */
public interface Identifier <ID extends Identifier>{

    /**
     * compare to other
     * @param other
     * @return
     */
    Boolean sameAs(ID other);

}
