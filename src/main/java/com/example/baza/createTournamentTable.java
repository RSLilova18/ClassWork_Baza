package com.example.baza;

public void createTournamentTable(){
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY(ID))";

        jdbcTemplate.execute(sql);
        System.out.println("Table created");
        }
private static final class PlayerMapper implements RowMapper<Player>{

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setName(rs.getString("name"));
        player.setNationality(rs.getString("nationality"));
        player.setBirthDate(rs.getTime("birth_date"));
        player.setTitles(rs.getInt("titles"));
        return player;
    }

}
    public List<Player> getPlayerByNationality(String nationality){
        String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
        return jdbcTemplate.query(sql , new PlayerMapper(), new Object[] {nationality});
    }