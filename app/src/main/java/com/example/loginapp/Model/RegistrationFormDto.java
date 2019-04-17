package com.example.loginapp.Model;

import java.util.List;

public class RegistrationFormDto {

    private List<RoleDto> roles;
    private List<OrganizationDto> organizations;

    public RegistrationFormDto() {
    }

    public RegistrationFormDto(List<RoleDto> roles, List<OrganizationDto> organizations) {
        this.roles = roles;
        this.organizations = organizations;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<OrganizationDto> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<OrganizationDto> organizations) {
        this.organizations = organizations;
    }
}
