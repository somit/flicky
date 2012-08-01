import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hashedin.flicky.hibernate.HibernateDao;
import com.hashedin.flicky.hibernate.IDataAccessObject;
import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.model.Album;

public class CreateAlbumTest {

	AlbumManager db;
	IDataAccessObject dao;

	@Before
	public void setUp() {

		db = new AlbumManager();
		dao = new HibernateDao();
	}

	@Test
	public void testCreateAlbum() {
        Album album = db.createAlbum("Somit", "description");
        dao.saveOrUpdate(album);
        dao.flush();
        Assert.assertEquals(album,db.getAnAlbum(album.getUid()));
      //  dao.delete(album);
      //  dao.flush();
	}

}
