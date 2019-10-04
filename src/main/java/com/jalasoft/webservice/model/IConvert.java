/*
 * IConvert 
 * 
 * Version 1
 *
 * Date 09/23/2019
 * 
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.model;

import com.jalasoft.webservice.exception.ConvertException;

/**
 * The interface is an abstraction of multiple converts
 */
public interface IConvert {

	Response Convert(Criteria cri) throws ConvertException;
}
