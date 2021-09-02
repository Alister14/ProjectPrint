USE [master]
GO

/****** Object:  Database [sito]    Script Date: 2021-07-03 17:06:15 ******/
CREATE DATABASE [sito]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'sito', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\sito.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'sito_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\sito_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [sito].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [sito] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [sito] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [sito] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [sito] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [sito] SET ARITHABORT OFF 
GO

ALTER DATABASE [sito] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [sito] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [sito] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [sito] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [sito] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [sito] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [sito] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [sito] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [sito] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [sito] SET  DISABLE_BROKER 
GO

ALTER DATABASE [sito] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [sito] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [sito] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [sito] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [sito] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [sito] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [sito] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [sito] SET RECOVERY FULL 
GO

ALTER DATABASE [sito] SET  MULTI_USER 
GO

ALTER DATABASE [sito] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [sito] SET DB_CHAINING OFF 
GO

ALTER DATABASE [sito] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [sito] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [sito] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [sito] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO

ALTER DATABASE [sito] SET QUERY_STORE = OFF
GO

ALTER DATABASE [sito] SET  READ_WRITE 
GO
