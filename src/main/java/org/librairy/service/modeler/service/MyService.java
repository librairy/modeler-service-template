package org.librairy.service.modeler.service;

import org.apache.avro.AvroRemoteException;
import org.librairy.service.modeler.facade.model.Dimension;
import org.librairy.service.modeler.facade.model.Element;
import org.librairy.service.modeler.facade.model.ModelerService;
import org.librairy.service.modeler.facade.model.Relevance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class MyService implements ModelerService {

    private static final Logger LOG = LoggerFactory.getLogger(MyService.class);

    @Value("#{environment['RESOURCE_FOLDER']?:'${resource.folder}'}")
    String resourceFolder;

    String model              ;

    @PostConstruct
    public void setup() throws IOException {

        //// Load resources
        //model              = Paths.get(resourceFolder,"resource.bin").toFile().getAbsolutePath();

        LOG.info("Service initialized");
    }

    @Override
    public List<Relevance> inference(String s) throws AvroRemoteException {
        //TODO
        return Collections.emptyList();
    }

    @Override
    public List<Double> shape(String s) throws AvroRemoteException {
        //TODO
        return Collections.emptyList();
    }

    @Override
    public List<Dimension> dimensions() throws AvroRemoteException {
        //TODO
        return Collections.emptyList();
    }

    @Override
    public List<Element> elements(int i, int i1) throws AvroRemoteException {
        //TODO
        return Collections.emptyList();
    }
}
