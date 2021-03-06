USE [master]
GO
/****** Object:  Database [bank]    Script Date: 2016/7/3 14:41:32 ******/
CREATE DATABASE [bank]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bank', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\bank.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'bank_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\bank_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [bank] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bank].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bank] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bank] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bank] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bank] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bank] SET ARITHABORT OFF 
GO
ALTER DATABASE [bank] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bank] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bank] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bank] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bank] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bank] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bank] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bank] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bank] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bank] SET  ENABLE_BROKER 
GO
ALTER DATABASE [bank] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bank] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bank] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bank] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bank] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bank] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bank] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bank] SET RECOVERY FULL 
GO
ALTER DATABASE [bank] SET  MULTI_USER 
GO
ALTER DATABASE [bank] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bank] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bank] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bank] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [bank] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'bank', N'ON'
GO
USE [bank]
GO
/****** Object:  Table [dbo].[account]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account](
	[id] [char](19) NOT NULL,
	[cust_id] [char](18) NOT NULL,
	[type] [int] NOT NULL,
	[createdate] [datetime] NULL DEFAULT (getdate()),
	[fixed] [money] NULL DEFAULT ((0)),
	[free] [money] NULL DEFAULT ((0)),
	[freedays] [int] NULL DEFAULT ((0)),
	[password] [char](32) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[account_type]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account_type](
	[id] [int] NOT NULL,
	[name] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[bonusrate]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bonusrate](
	[id] [int] NOT NULL,
	[bonusrate] [money] NOT NULL,
	[months] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[customer]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[id] [char](18) NOT NULL,
	[name] [varchar](20) NOT NULL,
	[address] [varchar](50) NOT NULL,
	[phonenumber] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[deposit_status]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[deposit_status](
	[id] [int] NOT NULL,
	[name] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[fixeddeposit]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[fixeddeposit](
	[id] [char](12) NOT NULL,
	[account_id] [char](19) NOT NULL,
	[money] [money] NOT NULL,
	[begindate] [datetime] NULL DEFAULT (getdate()),
	[months] [int] NOT NULL,
	[bonusrate] [int] NULL,
	[status] [int] NOT NULL DEFAULT ((1)),
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[history]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[history](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_id] [char](19) NOT NULL,
	[isfixed] [int] NULL DEFAULT ((0)),
	[money] [money] NOT NULL,
	[description] [varchar](50) NULL,
	[his_time] [datetime] NULL DEFAULT (getdate()),
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[power]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[power](
	[id] [int] NOT NULL,
	[name] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[id] [varchar](20) NOT NULL,
	[password] [char](32) NOT NULL,
	[power] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [fk_account_costomer] FOREIGN KEY([cust_id])
REFERENCES [dbo].[customer] ([id])
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [fk_account_costomer]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [fk_account_type] FOREIGN KEY([type])
REFERENCES [dbo].[account_type] ([id])
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [fk_account_type]
GO
ALTER TABLE [dbo].[fixeddeposit]  WITH CHECK ADD  CONSTRAINT [fk_fixeddeposit_account] FOREIGN KEY([account_id])
REFERENCES [dbo].[account] ([id])
GO
ALTER TABLE [dbo].[fixeddeposit] CHECK CONSTRAINT [fk_fixeddeposit_account]
GO
ALTER TABLE [dbo].[fixeddeposit]  WITH CHECK ADD  CONSTRAINT [fk_fixeddeposit_bonusrate] FOREIGN KEY([bonusrate])
REFERENCES [dbo].[bonusrate] ([id])
GO
ALTER TABLE [dbo].[fixeddeposit] CHECK CONSTRAINT [fk_fixeddeposit_bonusrate]
GO
ALTER TABLE [dbo].[fixeddeposit]  WITH CHECK ADD  CONSTRAINT [fk_fixeddeposit_status] FOREIGN KEY([status])
REFERENCES [dbo].[deposit_status] ([id])
GO
ALTER TABLE [dbo].[fixeddeposit] CHECK CONSTRAINT [fk_fixeddeposit_status]
GO
ALTER TABLE [dbo].[history]  WITH CHECK ADD  CONSTRAINT [fk_history_account] FOREIGN KEY([account_id])
REFERENCES [dbo].[account] ([id])
GO
ALTER TABLE [dbo].[history] CHECK CONSTRAINT [fk_history_account]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [fk_user_power] FOREIGN KEY([power])
REFERENCES [dbo].[power] ([id])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [fk_user_power]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [fixed_check] CHECK  (([fixed]>=(0)))
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [fixed_check]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [free_check] CHECK  (([free]>=(0)))
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [free_check]
GO
ALTER TABLE [dbo].[fixeddeposit]  WITH CHECK ADD  CONSTRAINT [money_check] CHECK  (([money]>(0)))
GO
ALTER TABLE [dbo].[fixeddeposit] CHECK CONSTRAINT [money_check]
GO
ALTER TABLE [dbo].[fixeddeposit]  WITH CHECK ADD  CONSTRAINT [months_check] CHECK  (([months]>=(3)))
GO
ALTER TABLE [dbo].[fixeddeposit] CHECK CONSTRAINT [months_check]
GO
/****** Object:  StoredProcedure [dbo].[p_addhis]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[p_addhis]
(
	@account_id char(19),
	@isFixed int,
	@money money,
	@description varchar(50)
)
as
begin
	insert into history (account_id,isfixed,[money],[description]) values(@account_id,@isFixed,@money,@description);
end
GO
/****** Object:  StoredProcedure [dbo].[p_alterbankuser]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[p_alterbankuser](
	@id varchar(20),
	@password char(32),
	@power int
)
as
begin
	declare @existed int;
	select @existed=count(*) from [user] where id=@id;
	if (@existed > 0)begin
		update [user] set [password]=@password,[power]=@power where id=@id;
		return 0;
	end
	else begin
		RAISERROR(N'用户不存在',16,1);
		return -1;
	end
end;
GO
/****** Object:  StoredProcedure [dbo].[p_createaccount]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[p_createaccount] 
(
	@customerid char(18),
	@customername varchar(20),
	@address varchar(20),
	@phonenumber varchar(20),
	@accountid char(19),
	@accounttype int,
	@password char(32)
)
as 
begin
	declare @customerexist int;
	select @customerexist=COUNT(*) from customer where id=@customerid;	
	
	if @customerexist = 0
		begin
		insert into customer values(@customerid,@customername,@address,@phonenumber);
		end
	insert into [account](id,cust_id,[type],[password]) values(@accountid,@customerid,@accounttype,@password);
	
end

GO
/****** Object:  StoredProcedure [dbo].[p_daily]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--procedure
CREATE PROCEDURE [dbo].[p_daily]
@lastupdatetime datetime
AS
BEGIN
	SET NOCOUNT ON;
	declare @date datetime ,@months int ,@id char(12),@freedays int,@account_id char(19);
	declare cur_fixeddeposit cursor for 
		select id,begindate,months from fixeddeposit where [status] = 1;
	open cur_fixeddeposit ;
	fetch next from cur_fixeddeposit into @id,@date,@months;
	while @@FETCH_STATUS=0
	begin
		if(@date+@months * 30 <= GETDATE())
		begin
		  declare @money money,@bonusrate money,@outmoney money,@inmoney money;
		  select @account_id=account_id,@money=[money],@bonusrate=bonusrate.bonusrate
		  from fixeddeposit,bonusrate
		  where fixeddeposit.bonusrate=bonusrate.id and fixeddeposit.id=@id;
		  set @outmoney = -@money;
		  set @inmoney = @money + @money * @bonusrate;
		  update account set free = free + @money + @money * @bonusrate,fixed=fixed - @money where account.id=@account_id;		  
		  update fixeddeposit set status = 0 where id = @id;
		  exec p_addhis @account_id,1,@outmoney,N'自动从定期转出';		  
		  exec p_addhis @account_id,0,@inmoney,N'自动转存到活期';		  
		end
		fetch next from cur_fixeddeposit into @id,@date,@months;
	end
	close cur_fixeddeposit;
	deallocate cur_fixeddeposit;
	declare cur_account cursor for select id,freedays from account;
	open cur_account ;
	fetch next from cur_account into @account_id,@freedays;
	while(@@FETCH_STATUS=0)
	begin
		declare @diff int;
		set @diff = (Year(GETDATE())-year(@lastupdatetime))*365 + (month(GETDATE())-MONTH(@lastupdatetime))*30 + (DAY(GETDATE())-day(@lastupdatetime));
		update account set freedays = @freedays + @diff where id=@account_id;
		fetch next from cur_account into @account_id,@freedays;
	end
	close cur_account;
	deallocate cur_account;
END

GO
/****** Object:  StoredProcedure [dbo].[p_deletebankuser]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[p_deletebankuser](
	@id varchar(20)
)
as
begin
    declare @existed int;
	select @existed=count(*) from [user] where id=@id;
	if (@existed > 0)begin
		delete from [user] where id=@id;
		return 0;
	end
	else begin
		RAISERROR(N'用户不存在',16,1);
		return -1;
	end
end
GO
/****** Object:  StoredProcedure [dbo].[p_depositfree]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[p_depositfree]
(
@account_id char(19),
@money money
)
as
begin	
	if(@money > 0)begin
		update account set free=free+@money where id=@account_id;
		exec p_addhis @account_id,0,@money,N'存入活期存款';
		return 0;
	end		
end
GO
/****** Object:  StoredProcedure [dbo].[p_withdrawfree]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[p_withdrawfree](
@account_id char(19),
@password char(32),
@money money
)
as
begin
	declare @truepassword char(32),@exist int,@yue money;
	select @truepassword=[password],@yue=free from account where id=@account_id;
	select @exist=count(*) from account where id = @account_id;	
	if(@password!=@truepassword)begin
		Raiserror (N'密码错误',16,1);
		return -1;		
	end
	if(@money>@yue)begin
		Raiserror (N'余额不足',16,1);
		return -1;		
	end					
	update account set [free]=[free]-@money where id=@account_id;
	exec p_addhis @account_id,0,@money,N'取出活期存款';					
	return 0;
end;
GO
/****** Object:  StoredProcedure [dbo].[p_withdrawnotintime]    Script Date: 2016/7/3 14:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[p_withdrawnotintime]
@cust_id char(18),
@fixeddeposit_id char(12),
@money money,
@passwordtobeverify char(32)
as
begin
	declare @yue money ,@account_id char(19),@begindate datetime,
	@truecust_id char(18),@months int,@bonusrate money,@interst money,@truepassword char(32);
	select @yue=[money],@account_id=account_id,@begindate=begindate from fixeddeposit where id = @fixeddeposit_id;	
	select @truecust_id=cust_id from account where id=@account_id;
	select @truepassword=[password] from account where id=@account_id;
	set @months = (Year(getdate())-year(@begindate))*12 + MONTH(GETDATE())-MONTH(@begindate);
	select @bonusrate=bonusrate from bonusrate where @months >= bonusrate.months;
	set @interst = @money * @bonusrate;	
	if (@yue < @money)begin 
		raiserror (N'余额不足',16,1);		
		return -1;
	end
	if (@cust_id!=@truecust_id)begin
		raiserror (N'身份证错误',16,1);		
		return -1;
	end
	if(@passwordtobeverify!=@truepassword)begin
		raiserror (N'密码错误',16,1);		
		return -1;
	end

	update fixeddeposit set [money]=[money]-@money where id=@fixeddeposit_id;
	update account set fixed=fixed-@money where id=@account_id;					
	exec p_addhis @account_id,1,@money,'提前取出定期存款';
	if @months >= 3	begin
		update account set free=free+@interst where id=@account_id;
		exec p_addhis @account_id,1,@interst,N'转存定期利息';
		return 0;
	end		
end	
GO
USE [master]
GO
ALTER DATABASE [bank] SET  READ_WRITE 
GO
