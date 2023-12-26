import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Before

class WallServiceTest {
    class WallServiceTest {

        @Before
        fun clearBeforeTest() {
            WallService.clear()
        }

        @Test
        fun updateExisting() {
            val post = Post(0, 0, 2, 12, "TEST", true, 4, true, true, true, false)
            val likesInfo = Likes.LikesInfo(10, true, true, true)
            val newPost = WallService.add(post.copy())
            val updatedPost = newPost.copy(text = "Updated Text")
            val isUpdated = WallService.update(updatedPost)
            assertEquals(true, isUpdated)
            @Test
            fun add() {
                val post = Post(0, 0, 2, 12, "TEST", true, 4, true, true, true, false)
                val likesInfo = Likes.LikesInfo(10, true, true, true)
                val newPost = WallService.add(post.copy())
                assertEquals(1, newPost.id)
            }
        }
    }
}