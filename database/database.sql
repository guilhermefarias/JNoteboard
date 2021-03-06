CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT,
	login VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(40) NOT NULL,
	name VARCHAR (255),
	email VARCHAR(255) NOT NULL UNIQUE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE note (
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
	note_text VARCHAR(10000) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_note_user FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE note_pos (
	note_id INT PRIMARY KEY NOT NULL,
	userpos_id INT,
	x INT,
	y INT,
	CONSTRAINT fk_pos_note FOREIGN KEY (note_id) REFERENCES note(id) ON DELETE CASCADE,
	CONSTRAINT fk_notepos_user FOREIGN KEY (userpos_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
