-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 08 mai 2024 à 17:04
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `infirmiers`
--

-- --------------------------------------------------------

--
-- Structure de la table `infirmier`
--

DROP TABLE IF EXISTS `infirmier`;
CREATE TABLE IF NOT EXISTS `infirmier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `iduser` int NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `numTel` int NOT NULL,
  `dateNaiss` varchar(30) NOT NULL,
  `grade` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idservice` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk2` (`idservice`),
  KEY `fk3` (`iduser`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `infirmier`
--

INSERT INTO `infirmier` (`id`, `iduser`, `nom`, `prenom`, `email`, `numTel`, `dateNaiss`, `grade`, `idservice`) VALUES
(1, 10, 'dd', 'dd', '', 25, '', 'dd', 1),
(2, 11, 'harra', 'samia', '', 1010101, '', 'cheg', 1),
(3, 12, 'gg', 'gg', 'gg', 2, '', 'gg', 1),
(4, 13, 'harra', 'maria', 'harramaria@gmail.com', 666985025, '02052002', 'chef', 1),
(5, 14, 'hhh', 'hh', 'hhh', 1111, 'hhhh', 'hh', 1),
(6, 15, 'hgh', 'jgjkgg', 'gjkgjkggggg', 15561321, 'klgklg', 'gjgjh', 2),
(7, 16, 'gggggg', 'ggggggg', 'ggkgg', 552, 'gggggg', 'tttttttt', 2),
(8, 17, 'hhhhhhh', 'jjjjjj', 'jjjj', 5555, 'jjjjjj', 'nnnn', 2),
(9, 18, 'hghg', 'jkjkj', 'kjlkjkl', 5546, 'jkjk', 'gggggg', 1),
(10, 23, 'dfd', 'dsfds', 'fdsfds', 1124563, 'fdsfd', 'sfdsdf', 1),
(11, 24, 'hghg', 'ghghg', 'ggfh', 15434, 'fghfh', 'hfhfg', 1),
(12, 24, 'hghg', 'ghghg', 'ggfh', 15434, 'fghfh', 'hfhfg', 1),
(13, 25, 'hara', 'samia', 'fffffffffffff', 52525, 'ddddddddd', 'chef', 1),
(14, 26, 'ffffff', 'fffff', 'fff', 2020, 'fff', 'ggg', 1);

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`id`, `nom`) VALUES
(1, 'soin d\'urgance'),
(2, 'soin specialise');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `mdp` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `mdp`, `role`) VALUES
(1, 'harramaria', 'projetmc', 'admin'),
(3, 'iheddadenkenza', 'projetmc', 'infirmier'),
(11, 'harrasamia@gmail.com', '010205', '+infirmier+'),
(12, 'gg', '02', '+infirmier+'),
(13, 'harramaria@gmail.com', '02052002', '+infirmier+'),
(14, 'hhh', 'hhhh', '+infirmier+'),
(15, 'gjkgjkggggg', 'klgklg', '+infirmier+'),
(16, 'ggkgg', 'gggggg', '+infirmier+'),
(17, 'jjjj', 'jjjjjj', '+infirmier+'),
(18, 'kjlkjkl', 'jkjk', '+infirmier+'),
(19, 'jjhj', 'hjhjh', '+infirmier+'),
(20, 'kenzaiha', '2002', '+infirmier+'),
(21, 'fdfd', 'fdsf', '+infirmier+'),
(22, 'fsfdsdf', 'fsdfd', '+infirmier+'),
(23, 'fdsfds', 'fdsfd', '+infirmier+'),
(24, 'ggfh', 'fghfh', '+infirmier+'),
(25, 'fffffffffffff', 'ddddddddd', '+infirmier+'),
(26, 'fff', 'fff', '+infirmier+');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
