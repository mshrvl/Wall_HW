data class Post(
    val id: Int,               // Добавлено свойство id для идентификации поста
    val reposts: Int,
    val owner_id: Int,
    val date: Int,
    val text: String,
    val friend_only: Boolean,
    val signer_id: Int,
    val can_pin: Boolean,
    val can_delete: Boolean,
    val can_edit: Boolean,
    val is_favourite: Boolean
)

object Likes {
    data class LikesInfo(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean,
    )
}

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        val newPost = post.copy(id = generateId())  // Присваиваем уникальный id новому посту
        posts += newPost
        return newPost
    }

    private var id = 0

    fun generateId(): Int {
        id++
        return id
    }

    fun update(post: Post): Boolean {
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == post.id) {
                posts[index] = post.copy()  // Обновляем существующий пост с новыми данными
                return true
            }
        }
        return false
    }
}

fun main() {
    val post = Post(0, 0, 2, 11, "TEST", true, 4, true, true, true, false)
    val likesInfo = Likes.LikesInfo(10, true, true, true)
    val newPost = WallService.add(post.copy())
    println("Post added with ID: ${newPost.id}")

    // Пример обновления поста
    val updatedPost = newPost.copy(text = "Updated Text")
    if (WallService.update(updatedPost)) {
        println("Post updated successfully")
    } else {
        println("Post not found")
    }
}
