package com.felipe.rest_with_spring_boot_java.controllers.docs;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.felipe.rest_with_spring_boot_java.data.dto.v1.PersonDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface PersonControllerDocs {

        @Operation(summary = "Finds all People", description = "Finds all People", tags = { "People" }, responses = {
                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                        @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
                        }),
                        @ApiResponse(description = "No Content", responseCode = "204"),
                        @ApiResponse(description = "Bad Request", responseCode = "400"),
                        @ApiResponse(description = "Unauthorized", responseCode = "401"),
                        @ApiResponse(description = "Not Found", responseCode = "404"),
                        @ApiResponse(description = "Internal Error", responseCode = "500")
        })
        List<PersonDTO> findAll();

        @Operation(summary = "Finds a person", description = "Find a specific person by your ID", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(schema = @Schema(implementation = PersonDTO.class))
                                        }),
                                        @ApiResponse(description = "No Content", responseCode = "204"),
                                        @ApiResponse(description = "Bad Request", responseCode = "400"),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401"),
                                        @ApiResponse(description = "Not Found", responseCode = "404"),
                                        @ApiResponse(description = "Internal Error", responseCode = "500")
                        })
        PersonDTO findByid(Long id);

        @Operation(summary = "Adds a new person", description = "Adds a new person by passing in a JSON, XML or YML representation of the person.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(schema = @Schema(implementation = PersonDTO.class))
                                        }),
                                        @ApiResponse(description = "No Content", responseCode = "204"),
                                        @ApiResponse(description = "Bad Request", responseCode = "400"),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401"),
                                        @ApiResponse(description = "Not Found", responseCode = "404"),
                                        @ApiResponse(description = "Internal Error", responseCode = "500")
                        })
        PersonDTO create(PersonDTO person);

        @Operation(summary = "Updates a person's information", description = "Updates a person's information by passing in a JSON, XML or YML representation of the updated person.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(schema = @Schema(implementation = PersonDTO.class))
                                        }),
                                        @ApiResponse(description = "No Content", responseCode = "204"),
                                        @ApiResponse(description = "Bad Request", responseCode = "400"),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401"),
                                        @ApiResponse(description = "Not Found", responseCode = "404"),
                                        @ApiResponse(description = "Internal Error", responseCode = "500")
                        })
        PersonDTO update(PersonDTO person);

        @Operation(summary = "Deletes a Book", description = "Deletes a specific person by their ID", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = "Success", responseCode = "200", content = {
                                                        @Content(schema = @Schema(implementation = PersonDTO.class))
                                        }),
                                        @ApiResponse(description = "No Content", responseCode = "204"),
                                        @ApiResponse(description = "Bad Request", responseCode = "400"),
                                        @ApiResponse(description = "Unauthorized", responseCode = "401"),
                                        @ApiResponse(description = "Not Found", responseCode = "404"),
                                        @ApiResponse(description = "Internal Error", responseCode = "500")
                        })
        ResponseEntity<?> delete(Long id);

}