package io.github.dimcloud.nvwa.ddd.domain;

/**
 * domain identity id
 *
 * @author hehe
 * 2020/10/26 10:05 上午
 **/
public interface Identity<ID extends Identifier> {

    /**
     * get domain identity id
     */
    ID getId();


}
