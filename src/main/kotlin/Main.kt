data class Post(
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
        posts += post
        return post
    }

    private var id = 0

    fun generateId(): Int {
        id++
        return id
    }
}


fun main() {}

fun add(post: Post) {
    val post = Post(0,2,11,"TEST",true, 4,true,true,true,false)

}


