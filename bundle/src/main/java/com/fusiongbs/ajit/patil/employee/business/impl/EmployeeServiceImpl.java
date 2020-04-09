package com.fusiongbs.ajit.patil.employee.business.impl;

import com.bmc.arsys.rx.application.common.ServiceLocator;
import com.bmc.arsys.rx.services.RxException;
import com.bmc.arsys.rx.services.action.domain.Action;
import com.bmc.arsys.rx.services.action.domain.ActionParameter;
import com.bmc.arsys.rx.services.common.Service;
import com.bmc.arsys.rx.services.common.domain.Scope;
import com.bmc.arsys.rx.services.record.RecordService;
import com.bmc.arsys.rx.services.record.domain.RecordInstance;
import com.fusiongbs.ajit.patil.employee.business.EmployeeService;
import com.fusiongbs.ajit.patil.employee.business.domain.Employee;
import org.hibernate.validator.constraints.NotBlank;

public class EmployeeServiceImpl implements Service {

    //@Override
    @Action(scope = Scope.PUBLIC)
    public String createEmployee (@ActionParameter(name = "Employee ID") @NotBlank String employeeId,
                                    @ActionParameter(name = "Name") @NotBlank String employeeName){

        //define GUID Field ID
        final String guidFieldId = String.valueOf(RecordInstance.GUID_FIELD_ID);

        ServiceLocator.getLogger().info("Creating employee record with ID: " + employeeId + " and Name: " + employeeName);

        //get Record Service
        RecordService recordService = ServiceLocator.getRecordService();

        //Create RecordInstance Object for Employee Record
        RecordInstance recordInstance = recordService.buildRecordInstance(EmployeeConstants.EMPLOYEE_RECORD_DEF_NAME);

        //Set Field Values
        recordInstance.setFieldValue(EmployeeConstants.EMPLOYEE_ID_FIELD_ID, employeeId);
        recordInstance.setFieldValue(EmployeeConstants.EMPLOYEE_NAME_FIELD_ID, employeeName);

        //try to create the record
        try{
            recordService.createRecordInstance(recordInstance);
        }
        catch (RxException e){
            ServiceLocator.getLogger().info("Employee record creation failed");
        }
        return recordInstance.getId();
    }



    public static EmployeeService getEmployeeService() {
        return (EmployeeService) ServiceLocator.getBundleService().getService(EmployeeServiceImpl.class.getName());
    }
}
