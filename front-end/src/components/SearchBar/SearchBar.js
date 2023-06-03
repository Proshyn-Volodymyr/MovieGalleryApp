import styles from './SearchBar.module.css';
import { useNavigate } from 'react-router-dom';
import { CgSearch } from 'react-icons/cg';
import { useState } from 'react';

export default function SearchBar({ handleSearch }) {
  const [query, setQuery] = useState('');
  let navigate = useNavigate();
  const handleSubmit = event => {
    event.preventDefault();
    handleSearch(query.trim());
    navigate(`/?movies?query=${query}&page`);
  };
  return (
    <form className={styles.searchForm} onSubmit={handleSubmit}>
      <input
        className={styles.searchBar}
        type="text"
        value={query}
        onChange={event => setQuery(event.target.value.toLowerCase())}
      ></input>
      <button className={styles.searchButton} type="submit">
        <CgSearch></CgSearch>
      </button>
    </form>
  );
}
