.class Landroid/support/design/widget/b$6;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/design/widget/l$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/design/widget/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/design/widget/b;


# direct methods
.method constructor <init>(Landroid/support/design/widget/b;)V
    .locals 0

    iput-object p1, p0, Landroid/support/design/widget/b$6;->a:Landroid/support/design/widget/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    sget-object v0, Landroid/support/design/widget/b;->a:Landroid/os/Handler;

    sget-object v1, Landroid/support/design/widget/b;->a:Landroid/os/Handler;

    const/4 v2, 0x0

    iget-object v3, p0, Landroid/support/design/widget/b$6;->a:Landroid/support/design/widget/b;

    invoke-virtual {v1, v2, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method public a(I)V
    .locals 5

    sget-object v0, Landroid/support/design/widget/b;->a:Landroid/os/Handler;

    sget-object v1, Landroid/support/design/widget/b;->a:Landroid/os/Handler;

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v4, p0, Landroid/support/design/widget/b$6;->a:Landroid/support/design/widget/b;

    invoke-virtual {v1, v2, p1, v3, v4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method
