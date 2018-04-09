.class Landroid/support/v7/widget/av$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/av;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/av;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/av;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    iget-boolean v0, v0, Landroid/support/v7/widget/av;->s:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->isLayoutRequested()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    iget-boolean v0, v0, Landroid/support/v7/widget/av;->p:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->requestLayout()V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    iget-boolean v0, v0, Landroid/support/v7/widget/av;->u:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/av;->t:Z

    goto :goto_0

    :cond_3
    iget-object v0, p0, Landroid/support/v7/widget/av$1;->a:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->d()V

    goto :goto_0
.end method
