USE teste_api_db;

GO

INSERT INTO carro(nome, descricao, url_foto, url_video, latitude, longitude, tipo)
VALUES ('Ferrari Enzo', 'Descrição Ferrari Enzo', 'http://www.livroandroid.com.br/livro/carros/luxo/Ferrari_Enzo.png', 'http://www.livroandroid.com.br/livro/carros/luxo/ferrari_enzo.mp4', '-23.564224', '-246.653156', 'luxo'),
	   ('Mercedes SLR McLaren', 'Descrição Mercedes SLR McLaren', 'http://www.livroandroid.com.br/livro/carros/luxo/Mercedes_McLaren.png', 'http://www.livroandroid.com.br/livro/carros/luxo/mclaren_slr.mp4', '-23.564224', '-46.653156', 'luxo'),
	   ('Dodge Challenger', 'Descrição Dodge Challenger', 'http://www.livroandroid.com.br/livro/carros/classicos/Dodge_Challenger.png', 'http://www.livroandroid.com.br/livro/carros/classicos/dodge_challenger.mp4', '', '', 'classicos'),
	   ('Ferrari FF', 'Descrição do Ferrari FF', '', '', '', '', 'esportivo'),
	   ('Audi GT Spyder', 'Descrição do Audi GT Spyder', '', '', '', '', 'esportivo'),
	   ('Porsche Panamera', 'Descrição do Porsche Panamera', '', '', '', '', 'esportivo');