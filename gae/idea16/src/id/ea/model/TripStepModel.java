package id.ea.model;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class TripStepModel {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TripStepModel(Long id, String name, String imageURI, String soundCloudURI) {
        super();
        this.id = id;
        this.name = name;
        this.imageURI = imageURI;
        this.soundCloudURI = soundCloudURI;
    }

    private String name;
    private String imageURI;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String soundCloudURI;

    public TripStepModel() {
        // TODO Auto-generated constructor stub
    }

    public TripStepModel(String name, String imageURI, String soundCloudURI) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.imageURI = imageURI;
        this.soundCloudURI = soundCloudURI;
    }

    public TripStepModel(Entity e) {
        // TODO Auto-generated constructor stub
        this.id = e.getKey().getId();
        this.name = (String) e.getProperty("name");
        this.imageURI = (String) e.getProperty("imageURI");
        this.soundCloudURI = (String) e.getProperty("soundCloudURI");
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getSoundCloudURI() {
        return soundCloudURI;
    }

    public void setSoundCloudURI(String soundCloudURI) {
        this.soundCloudURI = soundCloudURI;
    }

    public void save() {
        // TODO Auto-generated method stub
        DatastoreServiceFactory.getDatastoreService().put(toEntity());
    }

    private Entity toEntity() {
        Entity e = new Entity(this.getClass().getName());
        e.setProperty("name", this.name);
        e.setProperty("imageURI", this.imageURI);
        e.setProperty("soundCloudURI", this.soundCloudURI);

        return e;
    }

    public static List<TripStepModel> list() {
        // TODO Auto-generated method stub
        List<TripStepModel> tss = new ArrayList<TripStepModel>();

        Iterable<Entity> tsse = DatastoreServiceFactory.getDatastoreService().prepare(new Query(TripStepModel.class.getName())).asIterable();
        for (Entity e : tsse) {
            tss.add(new TripStepModel(e));
        }

        return tss;
    }

    public static TripStepModel get(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        return new TripStepModel(DatastoreServiceFactory.getDatastoreService().get(KeyFactory.createKey(TripStepModel.class.getName(), id)));
    }
}
