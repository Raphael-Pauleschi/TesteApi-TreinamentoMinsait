package com.minsait.emprestimo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Relation;

@RestController
@RequestMapping("api/v1/loan-manager/relations")
public class RelationController {
	@GetMapping
    public ResponseEntity<List<String>> getRelations() {
        List<String> relations = Arrays.stream(Relation.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(relations);
    }
}
