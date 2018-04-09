.class public Landroid/support/v4/h/i;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/h/i$a;,
        Landroid/support/v4/h/i$b;
    }
.end annotation


# static fields
.field private static final a:Landroid/support/v4/h/i$b;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v2, 0x0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    new-instance v0, Landroid/support/v4/h/i$a;

    invoke-direct {v0, v2}, Landroid/support/v4/h/i$a;-><init>(Landroid/support/v4/h/i$1;)V

    sput-object v0, Landroid/support/v4/h/i;->a:Landroid/support/v4/h/i$b;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Landroid/support/v4/h/i$b;

    invoke-direct {v0, v2}, Landroid/support/v4/h/i$b;-><init>(Landroid/support/v4/h/i$1;)V

    sput-object v0, Landroid/support/v4/h/i;->a:Landroid/support/v4/h/i$b;

    goto :goto_0
.end method

.method public static a(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 1

    sget-object v0, Landroid/support/v4/h/i;->a:Landroid/support/v4/h/i$b;

    invoke-virtual {v0, p0, p1}, Landroid/support/v4/h/i$b;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
