package org.dimcloud.nvwa.ddd.domain;

/**
 * domain entity interface
 *
 * @author hehe
 * @since 1.0.0
 */
public interface Entity<ID extends Identifier> {



    /**
     * domain entity unqic ID
     * @return ID
     */
    ID getId();

}
