package com.fusiongbs.ajit.patil.employee.application.datapage;

import com.bmc.arsys.rx.services.common.RestfulResource;
import com.bmc.arsys.rx.services.common.annotation.AccessControlledMethod;
import com.bmc.arsys.rx.services.common.annotation.RxInstanceTransactional;
import com.fusiongbs.ajit.patil.employee.business.EmployeeService;
import com.fusiongbs.ajit.patil.employee.business.domain.Employee;
import com.fusiongbs.ajit.patil.employee.business.impl.EmployeeServiceImpl;
import org.springframework.transaction.annotation.Isolation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("example/employee")
public class EmployeeResource implements RestfulResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RxInstanceTransactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackFor = { Exception.class })
    @AccessControlledMethod(authorization = AccessControlledMethod.AuthorizationLevel.Administrator, allowOperationInServerGroup = true)
    public Response post(@Context UriInfo uriInfo, Employee employee){

        EmployeeService employeeService = EmployeeServiceImpl.getEmployeeService();

        Employee newEmployee = employeeService.createEmployee(new Employee().getEmployeeId(), new Employee().getFullName());

        URI uri = uriInfo.getAbsolutePathBuilder().path(newEmployee.getId()).build();
        return Response.created(uri).build();
    }

}
