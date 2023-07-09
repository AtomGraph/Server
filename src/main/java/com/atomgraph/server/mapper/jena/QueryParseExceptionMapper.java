/*
 * Copyright 2014 Martynas Jusevičius <martynas@atomgraph.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atomgraph.server.mapper.jena;

import com.atomgraph.core.MediaTypes;
import org.apache.jena.query.QueryParseException;
import org.apache.jena.rdf.model.ResourceFactory;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import com.atomgraph.server.mapper.ExceptionMapperBase;
import jakarta.inject.Inject;

/**
 *
 * @author Martynas Jusevičius {@literal <martynas@atomgraph.com>}
 */
@Provider
public class QueryParseExceptionMapper extends ExceptionMapperBase implements ExceptionMapper<QueryParseException>
{

    @Inject
    public QueryParseExceptionMapper(MediaTypes mediaTypes)
    {
        super(mediaTypes);
    }
    
    @Override
    public Response toResponse(QueryParseException ex)
    {
        return getResponseBuilder(toResource(ex, Response.Status.BAD_REQUEST,
                        ResourceFactory.createResource("http://www.w3.org/2011/http-statusCodes#BadRequest")).
                    getModel()).
                status(Response.Status.BAD_REQUEST).
                build();
    }

}
