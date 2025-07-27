import React, { Component } from 'react';

class Post extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts = async () => {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      if (!response.ok) {
        throw new Error('Failed to fetch posts');
      }
      const posts = await response.json();
      this.setState({ posts });
    } catch (error) {
      this.setState({ error: error.message });
      this.componentDidCatch(error);
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error) {
    alert(`Error: ${error.message}`);
  }

  render() {
    const { posts, error } = this.state;

    if (error) {
      return <div className="error">Error: {error}</div>;
    }

    return (
      <div className="posts-container">
        <h1>Blog Posts</h1>
        {posts.map(post => (
          <div key={post.id} className="post">
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Post;