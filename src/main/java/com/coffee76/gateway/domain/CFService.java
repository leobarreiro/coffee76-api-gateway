package com.coffee76.gateway.domain;

import io.fabric8.kubernetes.api.model.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CFService {

	private String name;
	private Integer port;

	public static CFService fromService(Service service) {
		return CFService.builder()
				.name(service.getMetadata().getName())
				.port(service.getSpec().getPorts().get(0).getPort())
				.build();
	}
}
