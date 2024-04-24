package com.coffee76.gateway.domain;

import java.util.List;

import io.fabric8.kubernetes.api.model.Namespace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CFNamespace {

	private String name;
	private List<CFService> services;

	public static CFNamespace fromNamespace(Namespace namespace) {
		return CFNamespace.builder()
				.name(namespace.getMetadata().getName())
				.build();
	}

}
