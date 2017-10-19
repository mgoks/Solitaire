/**
 * 
 */
package module04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import module04.RecentFilesQueue;
import java.io.File;
import java.util.Iterator;

/**
 * @author Halil Murat
 * Exercise #3
 * With the help of EclEmma, write tests that achieve branch coverage.
 */

public class TestRecentFilesQueue
{
	@Test
	public void testAdd()
	{
		RecentFilesQueue queue = new RecentFilesQueue();

		// Covers the branch ab (from line 56 to 61)
		queue.add("");
		assertEquals(0, queue.size());
		
		// Covers acdfk
		queue.add("THISISNOTAFILE|||");
		assertEquals(0, queue.size());

		queue.add("testdata/file1.class.jet");
		assertEquals(1, queue.size());
		// First file in the queue should be testFile1
		assertEquals(new File("dir/file1.class.jet").getAbsoluteFile(), queue.iterator().next());
		
		queue.add("dir/file2.class.jet");
		assertEquals(2, queue.size());
		Iterator<File> iterator = queue.iterator();
		// First call to the iterator should return most recent file?
		assertEquals(new File("dir/file2.class.jet").getAbsoluteFile(), iterator.next());
		// Second call to the iterator should return the one added just before
		assertEquals(new File("dir/file1.class.jet").getAbsoluteFile(), iterator.next());
		
		queue.add("dir");
		assertEquals(2, queue.size());
		
		queue.add("dir/file3.class.jet");
		queue.add("dir/file4.class.jet");
		queue.add("dir/file5.class.jet");
		assertEquals(5, queue.size());
		iterator = queue.iterator();
		assertEquals(new File("dir/file5.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file4.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file3.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file2.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file1.class.jet").getAbsoluteFile(), iterator.next());
		
		queue.add("dir/file6.class.jet");
		assertEquals(5, queue.size());
		iterator = queue.iterator();
		assertEquals(new File("dir/file6.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file5.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file4.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file3.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file2.class.jet").getAbsoluteFile(), iterator.next());
		
		queue.add("dir/file4.class.jet");
		assertEquals(5, queue.size());
		iterator = queue.iterator();
		assertEquals(new File("dir/file4.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file6.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file5.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file3.class.jet").getAbsoluteFile(), iterator.next());
		assertEquals(new File("dir/file2.class.jet").getAbsoluteFile(), iterator.next());
	}
	
	@Test
	public void testGetMostRecentDirectory()
	{
		RecentFilesQueue q = new RecentFilesQueue();
		// q is empty
		assertEquals(0, q.size());
		assertEquals(new File("."), q.getMostRecentDirectory());
		
		q.add("dir1/file1.class.jet");
		assertEquals(1, q.size());
		assertEquals(new File("dir1").getAbsoluteFile(), q.getMostRecentDirectory());
		q.add("dir2/file2.class.jet");
		assertEquals(new File("dir2").getAbsoluteFile(), q.getMostRecentDirectory());
	}
	
	@Test
	public void testSize()
	{
		RecentFilesQueue aRFQ = new RecentFilesQueue();
		assertEquals(0, aRFQ.size());
	}
}
