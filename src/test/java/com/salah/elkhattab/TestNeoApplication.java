package com.salah.elkhattab;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salah.elkhattab.model.NeoObject;
import com.salah.elkhattab.services.NeoObjectService;
import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestNeoApplication {

    @Autowired
    private ApplicationContext context;

    /**
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void getNearEarthObjectsTest() throws ParseException, IOException {

        List<NeoObject> localObjects = getLocalObjects();
        assertNotNull(localObjects);

        List<NeoObject> remoteObjects = getRemoteObjects();
        assertNotNull(remoteObjects);

        assertTrue(localObjects.size() == remoteObjects.size());

        assertTrue(localObjects.size() == remoteObjects.size());
        NeoObjectService service = context.getBean(NeoObjectService.class);
        
        NeoObject localLargestNEO = service.getLargestNearEarthObject(localObjects);
        assertNotNull(localLargestNEO);

        NeoObject localClosestNEO = service.getClosestNearEarthObject(localObjects);
        assertNotNull(localClosestNEO);

        NeoObject remoteLargestNEO = service.getLargestNearEarthObject(remoteObjects);
        assertNotNull(remoteLargestNEO);
        assertTrue(localLargestNEO.equals(remoteLargestNEO));

        NeoObject remoteClosestNEO = service.getClosestNearEarthObject(remoteObjects);
        assertNotNull(remoteClosestNEO);
        assertTrue(localClosestNEO.equals(remoteClosestNEO));
    }

    /**
     *
     * @return @throws ParseException
     * @throws IOException
     */
    private List<NeoObject> getLocalObjects() throws ParseException, IOException {
        List<NeoObject> localObjects = new ArrayList<>();
        String content = null;

        File file = ResourceUtils.getFile("classpath:test.json");
        content = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();

        Iterator<JsonNode> iterator = mapper.readTree(content).get("near_earth_objects").elements();
        while (iterator.hasNext()) {
            for (JsonNode jsonNode : iterator.next()) {
                NeoObject neo = mapper.convertValue(jsonNode, NeoObject.class);
                localObjects.add(neo);
            }
        }

        return localObjects;
    }

    /**
     *
     * @return @throws ParseException
     */
    private List<NeoObject> getRemoteObjects() throws ParseException {
        List<NeoObject> remoteObjects = new ArrayList<>();
        Date startDate = NeoApplication.simpleDateFormat.parse("2018-04-19");
        Date endDate = startDate;
        NeoObjectService service = context.getBean(NeoObjectService.class);
        remoteObjects = service.getNearEarthObjects(NeoApplication.simpleDateFormat.format(startDate), NeoApplication.simpleDateFormat.format(endDate));
        return remoteObjects;
    }

}
