.class Landroid/support/v4/h/i$a;
.super Landroid/support/v4/h/i$b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/h/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v4/h/i$b;-><init>(Landroid/support/v4/h/i$1;)V

    return-void
.end method

.method synthetic constructor <init>(Landroid/support/v4/h/i$1;)V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/h/i$a;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 1

    invoke-static {p1, p2}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
