USE [master]
GO
/****** Object:  Database [J3.L.P0001]    Script Date: 7/23/2021 1:25:37 PM ******/
CREATE DATABASE [J3.L.P0001]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'J3.L.P0001', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\J3.L.P0001.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'J3.L.P0001_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\J3.L.P0001_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [J3.L.P0001] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3.L.P0001].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3.L.P0001] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [J3.L.P0001] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [J3.L.P0001] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [J3.L.P0001] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [J3.L.P0001] SET ARITHABORT OFF 
GO
ALTER DATABASE [J3.L.P0001] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [J3.L.P0001] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [J3.L.P0001] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [J3.L.P0001] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [J3.L.P0001] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [J3.L.P0001] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [J3.L.P0001] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [J3.L.P0001] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [J3.L.P0001] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [J3.L.P0001] SET  DISABLE_BROKER 
GO
ALTER DATABASE [J3.L.P0001] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [J3.L.P0001] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [J3.L.P0001] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [J3.L.P0001] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [J3.L.P0001] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [J3.L.P0001] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [J3.L.P0001] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [J3.L.P0001] SET RECOVERY FULL 
GO
ALTER DATABASE [J3.L.P0001] SET  MULTI_USER 
GO
ALTER DATABASE [J3.L.P0001] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [J3.L.P0001] SET DB_CHAINING OFF 
GO
ALTER DATABASE [J3.L.P0001] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [J3.L.P0001] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [J3.L.P0001] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'J3.L.P0001', N'ON'
GO
USE [J3.L.P0001]
GO
/****** Object:  Table [dbo].[Answer]    Script Date: 7/23/2021 1:25:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[questionId] [int] NOT NULL,
	[answer] [nvarchar](100) NOT NULL,
	[correct_answer] [int] NULL,
 CONSTRAINT [PK_Answer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Question]    Script Date: 7/23/2021 1:25:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](100) NOT NULL,
	[createdAt] [date] NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 7/23/2021 1:25:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](20) NOT NULL,
	[password] [nvarchar](100) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
	[type] [int] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Answer] ON 

INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (1, 1, N'USA', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (2, 1, N'Vietnam', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (3, 1, N'Canada', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (4, 1, N'UK', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (5, 2, N'Pacific Ocean', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (6, 2, N'Atlantic Ocean', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (7, 2, N'Indian Ocean', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (8, 2, N'Artic Ocean', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (9, 3, N'are', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (10, 3, N'am', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (11, 3, N'is', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (12, 3, N'be', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (13, 4, N'post office', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (14, 4, N'market', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (15, 4, N'bank', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (16, 4, N'library', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (17, 5, N'My', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (18, 5, N'Mine', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (19, 5, N'Yours', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (20, 5, N'Hers', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (21, 6, N'ten', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (22, 6, N'three', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (23, 6, N'five', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (24, 6, N'nine', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (25, 7, N'seven', 1)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (26, 7, N'one', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (27, 7, N'two', 0)
INSERT [dbo].[Answer] ([id], [questionId], [answer], [correct_answer]) VALUES (28, 7, N'nine', 0)
SET IDENTITY_INSERT [dbo].[Answer] OFF
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (1, N'Where is Hanoi?', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (2, N'What is the biggest ocean?', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (3, N'What __ your name?', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (4, N'Vegetables are sold in a ___', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (5, N'__ brother and I went on a canoe trip', CAST(N'2021-07-21' AS Date))
INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (6, N'What is sum of 2 and 3?', CAST(N'2021-07-23' AS Date))
INSERT [dbo].[Question] ([id], [question], [createdAt]) VALUES (7, N'What is sum of 3 and 4?', CAST(N'2021-07-23' AS Date))
SET IDENTITY_INSERT [dbo].[Question] OFF
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (1, N'teacher', N'teacher123', N'teacher@mail.com', 1)
INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (2, N'student', N'student123', N'student@mail.com', 0)
INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (3, N'student1', N'student123', N'student1@mail.com', 0)
INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (4, N'12345678901234567890', N'abc', N'email@email.com', 0)
INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (5, N'student2', N'stduent123', N'student2@mail.com', 0)
INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (6, N'admin', N'admin123', N'email@mail.com', 0)
INSERT [dbo].[User] ([id], [username], [password], [email], [type]) VALUES (7, N'student4', N'student123', N'student4@mail.com', 0)
SET IDENTITY_INSERT [dbo].[User] OFF
ALTER TABLE [dbo].[Answer]  WITH CHECK ADD  CONSTRAINT [FK_Answer_Question] FOREIGN KEY([questionId])
REFERENCES [dbo].[Question] ([id])
GO
ALTER TABLE [dbo].[Answer] CHECK CONSTRAINT [FK_Answer_Question]
GO
USE [master]
GO
ALTER DATABASE [J3.L.P0001] SET  READ_WRITE 
GO
