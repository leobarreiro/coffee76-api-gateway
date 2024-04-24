package com.coffee76.gateway.service;

import org.springframework.stereotype.Service;

import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

@Service
public class KubernetesService {

	public NamespaceList namespaces() {
		KubernetesClient cli = kubernetesClient();
		NamespaceList nsList = cli.namespaces().list();
		cli.close();
		return nsList;
	}

	public ServiceList services(final String namespaceName) {
		KubernetesClient cli = kubernetesClient();
		ServiceList svcList = cli.services().inNamespace(namespaceName).list();
		cli.close();
		return svcList;
	}

	private KubernetesClient kubernetesClient() {
		KubernetesClientBuilder kcBuilder = new KubernetesClientBuilder();
		KubernetesClient cli = kcBuilder.build();
		return cli;
	}

}
