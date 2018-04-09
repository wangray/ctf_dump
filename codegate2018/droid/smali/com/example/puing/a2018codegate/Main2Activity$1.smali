.class Lcom/example/puing/a2018codegate/Main2Activity$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/puing/a2018codegate/Main2Activity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/example/puing/a2018codegate/Main2Activity;


# direct methods
.method constructor <init>(Lcom/example/puing/a2018codegate/Main2Activity;)V
    .locals 0

    iput-object p1, p0, Lcom/example/puing/a2018codegate/Main2Activity$1;->a:Lcom/example/puing/a2018codegate/Main2Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    const-string v0, "Replace with your own action"

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;Ljava/lang/CharSequence;I)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    const-string v1, "Action"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->a()V

    return-void
.end method
