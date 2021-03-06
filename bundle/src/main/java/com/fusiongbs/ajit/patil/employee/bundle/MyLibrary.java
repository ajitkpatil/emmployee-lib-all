/*
 * Copyright (c) 2001-2015 BMC Software, Inc. All rights reserved. This software is the confidential
 * and proprietary information of BMC Software, Inc ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement between you and BMC Software, Inc.
 */

package com.fusiongbs.ajit.patil.employee.bundle;

import com.bmc.arsys.rx.services.common.RxBundle;
import com.bmc.arsys.rx.services.common.domain.WebResourceDefinition;
import com.fusiongbs.ajit.patil.employee.application.datapage.EmployeeResource;
import com.fusiongbs.ajit.patil.employee.business.impl.EmployeeServiceImpl;

/**
 * Rx Web Activator class.
 */
public class MyLibrary extends RxBundle {

    /* (non-Javadoc)
     * @see com.bmc.arsys.rx.business.common.RxBundle#register()
     */
    @Override
    protected void register() {
        //
        // TODO: Register static web resources and framework extensions.
        //
        // registerService(new MyService());
        //
        registerRestfulResource(new EmployeeResource());

        registerService(new EmployeeServiceImpl());

        registerStaticWebResource(String.format("/%s", getId()), "/webapp");
    }
}
