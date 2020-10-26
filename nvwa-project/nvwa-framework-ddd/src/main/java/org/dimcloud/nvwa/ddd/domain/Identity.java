package org.dimcloud.nvwa.ddd.domain;

/**
 * domain identity id
 *
 * @author feiyu
 * 2020/10/26 10:05 上午
 **/
public interface Identity<ID extends Identifier> {

    /**
     * get domain identity id
     */
    ID getId();


}