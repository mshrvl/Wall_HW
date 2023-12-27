import org.junit.Assert.*
import org.junit.Test
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addingPostShouldHaveNonZeroId() {
        val post = Post(0, 0, 2, 12, "T1", true, 4, true, true, true, false)
        val newPost = WallService.add(post.copy())
        assertTrue(newPost.id > 0)
    }

    @Test
    fun updatingPostWithExistingIdShouldReturnTrue() {
        val post = Post(0, 0, 2, 12, "T1", true, 4, true, true, true, false)
        val newPost = WallService.add(post.copy())


        val updatedPost = newPost.copy(text = "Updated Text")


        assertTrue(WallService.update(updatedPost))
    }

    @Test
    fun updatingPostWithNonExistingIdShouldReturnFalse() {
        val nonExistingPost = Post(999, 0, 2, 12, "Non-existing post", true, 4, true, true, true, false)
        assertFalse(WallService.update(nonExistingPost))
    }
}