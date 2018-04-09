.class Lcom/example/puing/a2018codegate/MainActivity$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/puing/a2018codegate/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/example/puing/a2018codegate/MainActivity;


# direct methods
.method constructor <init>(Lcom/example/puing/a2018codegate/MainActivity;)V
    .locals 0

    iput-object p1, p0, Lcom/example/puing/a2018codegate/MainActivity$2;->a:Lcom/example/puing/a2018codegate/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    iget-object v0, p0, Lcom/example/puing/a2018codegate/MainActivity$2;->a:Lcom/example/puing/a2018codegate/MainActivity;

    iget-object v0, v0, Lcom/example/puing/a2018codegate/MainActivity;->l:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/example/puing/a2018codegate/MainActivity$2;->a:Lcom/example/puing/a2018codegate/MainActivity;

    iget-object v1, v1, Lcom/example/puing/a2018codegate/MainActivity;->l:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->length()I

    move-result v1

    const/16 v2, 0xa

    if-lt v1, v2, :cond_0

    const/16 v2, 0x1a

    if-gt v1, v2, :cond_0

    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/example/puing/a2018codegate/Main2Activity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v2, "edittext"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    iget-object v0, p0, Lcom/example/puing/a2018codegate/MainActivity$2;->a:Lcom/example/puing/a2018codegate/MainActivity;

    invoke-virtual {v0, v1}, Lcom/example/puing/a2018codegate/MainActivity;->startActivity(Landroid/content/Intent;)V

    :cond_0
    return-void
.end method
