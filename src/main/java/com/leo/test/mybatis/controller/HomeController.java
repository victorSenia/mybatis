package com.leo.test.mybatis.controller;

import com.leo.test.mybatis.model.Browser;
import com.leo.test.mybatis.repository.BrowserRepository;
import com.leo.test.mybatis.util.BrowserMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Senchenko Viktor on 26.09.2016.
 */
@Path("/browser")
public class HomeController {

    private static final BrowserRepository REPOSITORY = new BrowserRepository();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String list() {
        return BrowserMapper.toString(REPOSITORY.list());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") Integer id) {
        Browser browserObject;
        if (id != null && (browserObject = REPOSITORY.get(id)) != null)
            return BrowserMapper.toString(browserObject);
        throw new BadRequestException();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String browser) {
        Browser browserObject = BrowserMapper.toBrowser(browser);
        if (browserObject != null && (browserObject = REPOSITORY.create(browserObject)) != null) {
            return BrowserMapper.toString(browserObject);
        }
        throw new BadRequestException();
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String edit(@PathParam("id") Integer id, String browser) {
        Browser browserObject = BrowserMapper.toBrowser(browser);
        if (browserObject != null && id != null) {
            browserObject.setId(id);
            Integer i;
            if ((browserObject = REPOSITORY.edit(browserObject)) != null) {
                return BrowserMapper.toString(browserObject);
            }
        }
        throw new BadRequestException();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        Browser browserObject;
        if (id != null && (browserObject = REPOSITORY.get(id)) != null)
            REPOSITORY.delete(browserObject);
    }
}
