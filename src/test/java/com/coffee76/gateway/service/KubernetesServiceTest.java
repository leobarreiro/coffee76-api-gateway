package com.coffee76.gateway.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coffee76.gateway.service.KubernetesService;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.ServiceList;

@SpringBootTest(classes = KubernetesService.class)
public class KubernetesServiceTest {

	@Autowired
	private KubernetesService service;

	@Test
	@DisplayName("Deve listar namespaces")
	public void testNamespaces() {
		NamespaceList nsList = service.namespaces();
		assertThat(nsList).isNotNull();
	}

	@Test
	@DisplayName("Deve listar serviços do namespace")
	public void testServiceList() {
		ServiceList svcList = service.services("auth");
		assertThat(svcList).isNotNull();
	}

}
